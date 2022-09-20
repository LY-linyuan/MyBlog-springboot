package com.tang.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tang.blog.dao.mapper.CommentMapper;
import com.tang.blog.dao.pojo.Comment;
import com.tang.blog.dao.pojo.SysUser;
import com.tang.blog.service.CommentsService;
import com.tang.blog.service.SysUserService;
import com.tang.blog.utils.UserThreadLocal;
import com.tang.blog.vo.CommentVo;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.UserVo;
import com.tang.blog.vo.params.CommentParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-20 8:20
 */

@Service
public class CommentsServiceImpl implements CommentsService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    private SysUserService sysUserService;

    @Override
    public Result commentsByArticleId(Long articleId) {
        /**
         * 1. 根据文章id 查询 评论列表 从 comment 表中查询
         * 2. 根据作者的id 查询作者的信息
         * 3. 判断 如果 level = 1 要去查询它有没有子评论
         * 4. 如果有 根据评论id 进行查询 （parent_id）
         */
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<Comment>();
        // 根据文章id进行查询
        queryWrapper.eq(Comment::getArticleId, articleId);
        // 根据层级关系进行查询
        queryWrapper.eq(Comment::getLevel, 1);
        List<Comment> commentList = commentMapper.selectList(queryWrapper);

        List<CommentVo> commentVoList = copyList(commentList);
        return Result.success(commentVoList);
    }

    private List<CommentVo> copyList(List<Comment> commentList) {

        List<CommentVo> commentVoList = new ArrayList<CommentVo>();
        for (Comment comment: commentList) {
            commentVoList.add(copy(comment));
        }
        return commentVoList;

    }

    private CommentVo copy(Comment comment) {
        CommentVo commentVo = new CommentVo();
        // copy相同属性
        BeanUtils.copyProperties(comment, commentVo);
        // 作者信息
        Long authorId = comment.getAuthorId();
        UserVo userVo = sysUserService.findUserVoById(authorId);
        commentVo.setAuthor(userVo);
        // 子评论
        Integer level = comment.getLevel();
        if (1 == level) {
            Long id = comment.getId();
            List<CommentVo> commentVoList = findCommentsByParentId(id);
            commentVo.setChildrens(commentVoList);
        }
        // to User 给谁评论
        if (level > 1) {
            Long toUid = comment.getToUid();
            UserVo toUserVo = sysUserService.findUserVoById(toUid);
            commentVo.setToUser(toUserVo);
        }
        return commentVo;
    }

    private List<CommentVo> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<Comment>();
        queryWrapper.eq(Comment::getParentId, id);
        queryWrapper.eq(Comment::getLevel, 2);
        List<Comment> commentList = commentMapper.selectList(queryWrapper);
        return copyList(commentList);
    }

    @Override
    public Result comment(CommentParam commentParam) {
        // 拿到当前用户
        SysUser sysUser = UserThreadLocal.get();
        Comment comment = new Comment();
        comment.setArticleId(commentParam.getArticleId());
        comment.setAuthorId(sysUser.getId());
        comment.setContent(commentParam.getContent());
        comment.setCreateDate(System.currentTimeMillis());
        Long parent = commentParam.getParent();
        if (parent == null || parent == 0) {
            comment.setLevel(1);
        }else{
            comment.setLevel(2);
        }
        // 如果是空，parent就是0
        comment.setParentId(parent == null ? 0 : parent);
        Long toUserId = commentParam.getToUserId();
        comment.setToUid(toUserId == null ? 0 : toUserId);
        commentMapper.insert(comment);
        return Result.success(null);
    }
}

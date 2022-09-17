package com.tang.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tang.blog.dao.mapper.ArticleMapper;
import com.tang.blog.dao.pojo.Article;
import com.tang.blog.service.ArticleService;
import com.tang.blog.service.SysUserService;
import com.tang.blog.service.TagService;
import com.tang.blog.vo.ArticleVo;
import com.tang.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-17 14:42
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private TagService tagService;
    @Resource
    private SysUserService sysUserService;


    @Override
    public List<ArticleVo> listArticlesPage(PageParams pageParams) {
        /**
         *  1. 分页查询article数据库表
         */
        Page<Article> page = new Page<Article>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<Article>();
        // 是否置顶进行排序   // 事件倒叙排列相当于order by create_date desc
        queryWrapper.orderByDesc(Article::getWeight, Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<Article> records = articlePage.getRecords();
        // 要返回的我们定义的vo数据, 就是对应的前端数据, 不应该只返回现在的数据, 需要进一步进行处理
        List<ArticleVo> articleVoList = copyList(records, true, true);
        return articleVoList;
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<ArticleVo>();

        for (Article record: records) {
            articleVoList.add(copy(record, isTag, isAuthor));
        }
        return articleVoList;
    }

    // copy的作用是对应copyList, 集合之间的copy分解成集合元素之间的copy
    private ArticleVo copy(Article article, Boolean isTag, Boolean isAuthor) {
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        // 并不是所有的接口都需要标签和作者信息
        if (isTag) {
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }

        if (isAuthor) {
            Long authorId = article.getAuthorId();
            articleVo.setAuthor(sysUserService.findUserById(authorId).getNickname());
        }

        return articleVo;
    }
}

package com.tang.blog.service;

import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.CommentParam;

public interface CommentsService {
    /**
     * 根据文章id查询评论列表
     * @param articleId
     * @return
     */
    Result commentsByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}

package com.tang.blog.service;

import com.tang.blog.vo.ArticleVo;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.PageParams;

import java.util.List;

public interface ArticleService {

    /**
     * 分页查询文章列表
     * @param pageParams
     * @return
     */
    List<ArticleVo> listArticlesPage(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticle(int limit);

    Result listArchives();

    Result findArticleById(Long articleId);
}

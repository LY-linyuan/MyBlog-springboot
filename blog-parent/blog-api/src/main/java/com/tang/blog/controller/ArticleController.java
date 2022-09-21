package com.tang.blog.controller;

import com.tang.blog.dao.pojo.Article;
import com.tang.blog.service.ArticleService;
import com.tang.blog.vo.ArticleVo;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.ArticleParam;
import com.tang.blog.vo.params.PageParams;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-17 12:15
 */
// 都是json数据进行交互
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 首页文章列表
     * @param pageParams
     * @return
     */
    // Result 是统一返回结果
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {
        // ArticleVo 页面接收的数据
        List<ArticleVo> articleVoList = articleService.listArticlesPage(pageParams);
        return Result.success(articleVoList);
    }

    @PostMapping("/hot")
    public Result hotArticle() {
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    @PostMapping("/new")
    public Result newArticle() {
        int limit = 5;
        return articleService.newArticle(limit);
    }

    @PostMapping("/listArchives")
    public Result listArchives() {
        return articleService.listArchives();
    }

    @PostMapping("/view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId) {
        return articleService.findArticleById(articleId);
    }

    @PostMapping("/publish")
    public Result publish(@RequestBody ArticleParam articleParam) {
        return articleService.publish(articleParam);
    }

}

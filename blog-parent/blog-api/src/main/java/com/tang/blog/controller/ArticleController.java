package com.tang.blog.controller;

import com.tang.blog.service.ArticleService;
import com.tang.blog.vo.ArticleVo;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.PageParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

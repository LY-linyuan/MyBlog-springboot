package com.tang.blog.controller;

import com.tang.blog.service.CommentsService;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.CommentParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author 临渊
 * @Date 2022-09-20 8:13
 */

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Resource
    private CommentsService commentsService;

    @GetMapping("/article/{id}")
    public Result comments(@PathVariable("id") Long articleId) {
        return commentsService.commentsByArticleId(articleId);
    }

    @PostMapping("/create/change")
    public Result createChange(@RequestBody CommentParam commentParam) {
        return commentsService.comment(commentParam);
    }

}

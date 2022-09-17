package com.tang.blog.controller;

import com.tang.blog.dao.pojo.Tag;
import com.tang.blog.service.TagService;
import com.tang.blog.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-17 19:24
 */

@RestController
@RequestMapping("/tags")
public class TagController {

    @Resource
    TagService tagService;

    @GetMapping("/hot")
    public Result hot() {
        int limit = 6;
        List<Tag> tagList = tagService.hots(limit);
        return Result.success(tagList);
    }

}

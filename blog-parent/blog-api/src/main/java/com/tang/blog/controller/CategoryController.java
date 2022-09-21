package com.tang.blog.controller;

import com.tang.blog.service.CategoryService;
import com.tang.blog.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 临渊
 * @Date 2022-09-20 23:20
 */

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping
    public Result listCategory() {
        return categoryService.findAll();
    }

}

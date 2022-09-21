package com.tang.blog.service;

import com.tang.blog.vo.CategoryVo;
import com.tang.blog.vo.Result;

/**
 * @Author 临渊
 * @Date 2022-09-19 21:28
 */
public interface CategoryService {
    CategoryVo findCategoryById(Long id);

    Result findAll();
}

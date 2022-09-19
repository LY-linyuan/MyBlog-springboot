package com.tang.blog.service.impl;

import com.tang.blog.dao.mapper.CategoryMapper;
import com.tang.blog.dao.pojo.Category;
import com.tang.blog.service.CategoryService;
import com.tang.blog.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 临渊
 * @Date 2022-09-19 21:29
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCategoryById(Long id){
        Category category = categoryMapper.selectById(id);
        CategoryVo categoryVo = new CategoryVo();
        // 因为category, categoryVo属性一样所以可以使用 BeanUtils.copyProperties
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}

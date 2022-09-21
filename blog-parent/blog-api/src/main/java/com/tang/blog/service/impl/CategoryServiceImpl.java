package com.tang.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tang.blog.dao.mapper.CategoryMapper;
import com.tang.blog.dao.pojo.Category;
import com.tang.blog.service.CategoryService;
import com.tang.blog.vo.CategoryVo;
import com.tang.blog.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Result findAll() {
        // 没有任何参数，所有一个空的LambdaQueryWrapper即可
        List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<>());
        return Result.success(copyList(categoryList));
    }

    @Override
    public Result findAllDetail() {
        List<Category> categoryList = categoryMapper.selectList(new LambdaQueryWrapper<>());
        // 页面交互的对象
        return Result.success(copyList(categoryList));
    }

    private List<CategoryVo> copyList(List<Category> categoryList) {
        List<CategoryVo> categoryVoList = new ArrayList<CategoryVo>();
        for (Category category: categoryList) {
            categoryVoList.add(copy(category));
        }
        return categoryVoList;
    }

    private CategoryVo copy(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        // id不一致要重新设立
        BeanUtils.copyProperties(category, categoryVo);
        categoryVo.setId(category.getId());
        return categoryVo;
    }

    @Override
    public Result categoriesDetailById(Long id) {
        Category category = categoryMapper.selectById(id);
        // 转换为CategoryVo
        CategoryVo categoryVo = copy(category);
        return Result.success(categoryVo);
    }
}

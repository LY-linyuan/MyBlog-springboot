package com.tang.blog.service;

import com.tang.blog.dao.pojo.Tag;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.TagVo;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-17 15:18
 */
public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);

    List<Tag> hots(int limit);

    Result findAll();

    Result findAllDetail();

    Result findADetailById(Long id);
}

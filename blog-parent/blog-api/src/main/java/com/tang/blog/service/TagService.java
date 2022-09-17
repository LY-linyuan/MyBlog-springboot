package com.tang.blog.service;

import com.tang.blog.vo.TagVo;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-17 15:18
 */
public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);
}

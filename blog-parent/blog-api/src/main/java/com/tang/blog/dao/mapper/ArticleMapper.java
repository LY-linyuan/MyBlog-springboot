package com.tang.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.blog.dao.dos.Archives;
import com.tang.blog.dao.pojo.Article;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-17 12:22
 */
public interface ArticleMapper extends BaseMapper<Article> {

    List<Archives> listArchives();
}

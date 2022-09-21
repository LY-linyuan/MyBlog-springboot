package com.tang.blog.dao.pojo;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-21 10:08
 */
@Data
public class ArticleTag {

    private Long id;

    private Long articleId;

    private Long tagId;

}

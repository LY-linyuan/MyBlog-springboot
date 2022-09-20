package com.tang.blog.dao.pojo;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-19 23:27
 */
@Data
public class Comment {

    private Long id;

    private String content;

    private Long createDate;

    private Long articleId;

    private Long authorId;

    private Long parentId;

    private Long toUid;

    private Integer level;
}
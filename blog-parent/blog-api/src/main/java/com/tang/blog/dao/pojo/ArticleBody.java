package com.tang.blog.dao.pojo;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-19 21:09
 */

@Data
public class ArticleBody {

    private Long id;
    private String content;
    private String contentHtml;
    private Long articleId;

}

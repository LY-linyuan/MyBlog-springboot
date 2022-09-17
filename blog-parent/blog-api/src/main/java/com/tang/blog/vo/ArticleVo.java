package com.tang.blog.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-17 14:37
 */

@Data
public class ArticleVo {

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

    private ArticleBodyVo body;

    private List<TagVo> tags;

    private List<CategoryVo> categorys;

}

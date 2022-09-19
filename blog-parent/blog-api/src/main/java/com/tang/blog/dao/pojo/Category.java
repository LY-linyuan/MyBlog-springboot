package com.tang.blog.dao.pojo;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-19 21:10
 */

@Data
public class Category {

    private Long id;
    private String avatar;
    private String categoryName;
    private String description;

}

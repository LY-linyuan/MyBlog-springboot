package com.tang.blog.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-23 13:17
 */

@Data
public class PageResult<T> {

    private List<T> list;

    private Long total;

}

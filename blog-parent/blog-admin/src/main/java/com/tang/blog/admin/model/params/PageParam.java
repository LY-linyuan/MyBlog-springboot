package com.tang.blog.admin.model.params;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-23 13:14
 */

@Data
public class PageParam {

    private Integer currentPage;

    private Integer pageSize;

    private String queryString;

}

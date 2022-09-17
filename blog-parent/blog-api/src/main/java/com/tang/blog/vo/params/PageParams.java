package com.tang.blog.vo.params;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-17 12:39
 */

@Data
public class PageParams {
    private int page = 1;
    private int pageSize = 10;
}

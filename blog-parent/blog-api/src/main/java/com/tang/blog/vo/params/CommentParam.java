package com.tang.blog.vo.params;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-20 9:28
 */

@Data
public class CommentParam {

    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;
}

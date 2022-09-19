package com.tang.blog.vo;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-19 8:34
 */

@Data
public class LoginUserVo {

    private Long id;
    private String account;
    private String nickname;
    private String avatar;

}

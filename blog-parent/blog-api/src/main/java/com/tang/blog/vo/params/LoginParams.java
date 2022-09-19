package com.tang.blog.vo.params;

import lombok.Data;

/**
 * @Author 临渊
 * @Date 2022-09-18 23:35
 */

@Data
public class LoginParams {

    private String account;
    private String password;
    private String nickname;

}

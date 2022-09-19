package com.tang.blog.service;

import com.tang.blog.dao.pojo.SysUser;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.LoginParams;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 临渊
 * @Date 2022-09-18 23:36
 */

@Transactional
public interface LoginService {
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    Result logout(String token);

    Result register(LoginParams loginParams);
}

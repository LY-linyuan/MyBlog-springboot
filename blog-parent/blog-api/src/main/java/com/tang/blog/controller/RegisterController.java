package com.tang.blog.controller;

import com.tang.blog.service.LoginService;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.LoginParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 临渊
 * @Date 2022-09-19 13:21
 */

@RestController
@RequestMapping("/register")
public class RegisterController {


    @Resource
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParams loginParams) {
        // sso单点登录, 后期如果把登录注册功能提输出(单独的服务, 可以独立提供接口服务)
        return loginService.register(loginParams);
    }

}

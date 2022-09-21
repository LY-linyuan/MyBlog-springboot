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
 * @Date 2022-09-18 23:33
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    // 浅谈@RequestMapping @ResponseBody 和 @RequestBody 注解的用法与区别
    // @RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；而最常用的使用请求体传参的无疑是POST请求了，所以使用@RequestBody接收数据时，一般都用POST方式进行提交。

    @PostMapping
    public Result login(@RequestBody LoginParams loginParams) {
        // 登录 验证用户 访问用户表
        return loginService.login(loginParams);
    }

}

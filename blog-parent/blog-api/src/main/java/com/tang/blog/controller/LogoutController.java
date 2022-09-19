package com.tang.blog.controller;

import com.tang.blog.service.LoginService;
import com.tang.blog.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 临渊
 * @Date 2022-09-19 9:19
 */

@RestController
@RequestMapping("/logout")
public class LogoutController {

    @Resource
    private LoginService loginService;

    @GetMapping
    public Result logout(@RequestHeader("Authorization") String token) {
        return loginService.logout(token);
    }

}

package com.tang.blog.controller;

import com.tang.blog.dao.pojo.SysUser;
import com.tang.blog.utils.UserThreadLocal;
import com.tang.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 临渊
 * @Date 2022-09-19 17:25
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping
    public Result test() {
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }

}

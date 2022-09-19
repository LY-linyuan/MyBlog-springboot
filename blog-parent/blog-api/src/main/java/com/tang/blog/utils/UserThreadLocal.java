package com.tang.blog.utils;

import com.tang.blog.dao.pojo.SysUser;

/**
 * @Author 临渊
 * @Date 2022-09-19 17:54
 */

public class UserThreadLocal {

    private UserThreadLocal(){};

    // 线程变量隔离
    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<SysUser>();

    public static void put(SysUser sysUser) {
        LOCAL.set(sysUser);
    }

    public static SysUser get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }
}

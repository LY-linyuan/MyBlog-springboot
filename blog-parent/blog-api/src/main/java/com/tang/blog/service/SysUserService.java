package com.tang.blog.service;

import com.tang.blog.dao.pojo.SysUser;

/**
 * @Author 临渊
 * @Date 2022-09-17 16:53
 */
public interface SysUserService {
    SysUser findUserById(Long authorId);
}

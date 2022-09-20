package com.tang.blog.service;

import com.tang.blog.dao.pojo.SysUser;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.UserVo;

/**
 * @Author 临渊
 * @Date 2022-09-17 16:53
 */
public interface SysUserService {
    SysUser findUserById(Long authorId);

    SysUser findUser(String account, String pwd);

    Result findUserByToken(String token);

    SysUser finUserByAccount(String account);

    void save(SysUser sysUser);

    UserVo findUserVoById(Long id);
}

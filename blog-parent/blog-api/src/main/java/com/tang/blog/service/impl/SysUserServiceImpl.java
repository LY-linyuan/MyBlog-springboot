package com.tang.blog.service.impl;

import com.tang.blog.dao.mapper.SysUserMapper;
import com.tang.blog.dao.pojo.SysUser;
import com.tang.blog.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 临渊
 * @Date 2022-09-17 16:55
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long authorId) {
        // 根据id查询
        // 防止sysUser加一个判断
        SysUser sysUser = sysUserMapper.selectById(authorId);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("tang");
        }
        return sysUser;
    }
}

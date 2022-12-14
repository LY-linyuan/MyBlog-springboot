package com.tang.blog.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tang.blog.admin.pojo.Permission;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-09-23 13:23
 */


public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> findPermissionsByAdminId(Long adminId);
}

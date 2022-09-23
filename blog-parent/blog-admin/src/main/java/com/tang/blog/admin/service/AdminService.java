package com.tang.blog.admin.service;

import com.tang.blog.admin.pojo.Admin;
import com.tang.blog.admin.pojo.Permission;

import java.util.List;

public interface AdminService {

    Admin findAdminByUserName(String username);

    List<Permission> findPermissionsByAdminId(Long id);
}

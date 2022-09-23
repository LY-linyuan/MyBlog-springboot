package com.tang.blog.admin.service;

import com.tang.blog.admin.model.params.PageParam;
import com.tang.blog.admin.pojo.Permission;
import com.tang.blog.admin.vo.Result;

/**
 * @Author 临渊
 * @Date 2022-09-23 13:16
 */

public interface PermissionService {
    Result listPermission(PageParam pageParam);

    Result add(Permission permission);

    Result update(Permission permission);

    Result delete(Long id);
}

package com.tang.blog.admin.controller;

import com.tang.blog.admin.model.params.PageParam;
import com.tang.blog.admin.pojo.Permission;
import com.tang.blog.admin.service.PermissionService;
import com.tang.blog.admin.vo.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author 临渊
 * @Date 2022-09-23 13:11
 */


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private PermissionService permissionService;

    @PostMapping("/permission/permissionList")
    public Result permissionList(@RequestBody PageParam pageParam) {
        return permissionService.listPermission(pageParam);
    }

    @PostMapping("/permission/add")
    public Result add(@RequestBody Permission permission){
        return permissionService.add(permission);
    }

    @PostMapping("/permission/update")
    public Result update(@RequestBody Permission permission){
        return permissionService.update(permission);
    }

    @GetMapping("/permission/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        return permissionService.delete(id);
    }


}

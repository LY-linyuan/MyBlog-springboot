package com.tang.blog.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinitions;

/**
 * @Author 临渊
 * @Date 2022-09-23 14:06
 */

@Data
public class Admin {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;
}

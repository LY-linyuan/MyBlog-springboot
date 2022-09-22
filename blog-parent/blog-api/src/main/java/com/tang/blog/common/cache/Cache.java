package com.tang.blog.common.cache;

import java.lang.annotation.*;

/**
 * @Author 临渊
 * @Date 2022-09-21 22:43
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    long expire() default 1 * 60 * 1000;

    String name() default "";

}

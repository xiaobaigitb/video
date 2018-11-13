package com.zhiyou.video.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解-用于设置访问的权限人物
 */
@Retention(RetentionPolicy.RUNTIME)//表示使用该注解的方法运行时自定义的注解起作用
public @interface Permission {
    String[] role();
}

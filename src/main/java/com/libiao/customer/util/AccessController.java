package com.libiao.customer.util;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessController {

    //默认不走权限校验
    boolean isValidate() default false;
    //映射路径（用来对应权限菜单多对多的情况，主要是用于字典相关的权限）
    String[] mappingPath() default {};

}

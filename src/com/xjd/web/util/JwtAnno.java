package com.xjd.web.util;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/1/24.
 */
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtAnno {
    String name() default "xjxjjxjxjj";
    String[] Prams();

}

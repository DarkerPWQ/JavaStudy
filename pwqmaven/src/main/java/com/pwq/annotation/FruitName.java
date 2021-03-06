package com.pwq.annotation;

import java.lang.annotation.*;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:06 2017/8/16
 * @Modified By：
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}

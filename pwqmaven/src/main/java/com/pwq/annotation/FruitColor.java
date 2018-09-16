package com.pwq.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:09 2017/8/16
 * @Modified By：
 */
@Target(ElementType.FIELD)

public @interface FruitColor {
    public enum Color{BULE,RED,GREEN};
    public Color fruitColor() default Color.GREEN;
}

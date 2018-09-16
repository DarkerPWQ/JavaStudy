package com.pwq.DesignPatterns.SimpleFactory.BuildePattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 14:56 2017/9/19
 * @Modified By：
 */
public  interface Build {
    public void BuildFood();
    public void BuildDrink();
    public Meal getResult();
}

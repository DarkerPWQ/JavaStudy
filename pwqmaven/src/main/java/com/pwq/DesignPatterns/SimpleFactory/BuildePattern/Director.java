package com.pwq.DesignPatterns.SimpleFactory.BuildePattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:24 2017/9/19
 * @Modified By：
 */
public class Director {
    private Build build;

    public Director(Build build) {
        this.build = build;
    }
    public Meal getMeal(){
        this.build.BuildFood();
        this.build.BuildDrink();
        return this.build.getResult();
    }
}

package com.pwq.DesignPatterns.SimpleFactory.BuildePattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:22 2017/9/19
 * @Modified By：
 */
public class MealBBuild implements Build {
    private Meal meal;

    public MealBBuild() {
        this.meal = new Meal();
    }

    @Override
    public void BuildFood() {
        System.out.println("套餐B");

    }

    @Override
    public void BuildDrink() {
        System.out.println("饮料B");
    }

    @Override
    public Meal getResult() {
        return this.meal;
    }
}

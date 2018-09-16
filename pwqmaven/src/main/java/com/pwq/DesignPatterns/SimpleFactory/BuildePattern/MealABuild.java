package com.pwq.DesignPatterns.SimpleFactory.BuildePattern;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 15:11 2017/9/19
 * @Modified By：
 */
public class MealABuild implements Build {
    private Meal meal;

    public MealABuild() {
        this.meal = new Meal();
    }

    @Override
    public void BuildFood() {
        this.meal.setFood("套餐A");

    }

    @Override
    public void BuildDrink() {
        this.meal.setDrink("饮料A");
    }

    @Override
    public Meal getResult() {
        return meal;
    }
}

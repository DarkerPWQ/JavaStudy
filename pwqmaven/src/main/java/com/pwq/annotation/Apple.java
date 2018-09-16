package com.pwq.annotation;


/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:20 2017/8/16
 * @Modified By：
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor= FruitColor.Color.RED)
    private String appleColor;




    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }


    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "appleName='" + appleName + '\'' +
                ", appleColor='" + appleColor + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Apple apple =  new Apple();
        System.out.println(apple);

    }
}

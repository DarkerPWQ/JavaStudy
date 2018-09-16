package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/6/2.
 */

public enum Color {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        for (Color simpleEnum : Color.values()) {
            System.out.println(simpleEnum + "  ordinal  " + simpleEnum.getName());
        }
        System.out.println(Color.RED.getIndex());

        int a[] = {1,2,3};
        int[] b = {2,3,4};

    }
}
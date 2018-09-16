package com.pwq.mavenT;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by BF100500 on 2017/6/26.
 */
public class Student implements Serializable{
    static {
        System.out.println("我是静态代码块");
    }
    private static long time = Calendar.getInstance().getTimeInMillis();
    @JsonProperty("code")
    private String name;
    private char sex;
    private int year;
    private double gpa;

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    private Integer t;

    public Student() {
        System.out.println("我是构造器");
        for(int i = 0;i<10000;i++);
        System.out.println(time+"---"+Calendar.getInstance().getTimeInMillis());
    }

    public Student(String name, char sex, int year, double gpa) {
        this.name = name;
        this.sex = sex;
        this.year = year;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", year=" + year +
                ", gpa=" + gpa +
                ", t=" + t +
                '}';
    }
}

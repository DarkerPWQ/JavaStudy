package com.pwq.Stream;

import java.io.Serializable;

/**
 * Created by pwq on 2018/1/21.
 */
public class Person implements Serializable{
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

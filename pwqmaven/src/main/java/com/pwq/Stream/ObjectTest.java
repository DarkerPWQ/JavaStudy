package com.pwq.Stream;


import org.junit.Test;

import java.io.*;

/**
 * Created by pwq on 2018/1/21.
 */
public class ObjectTest {
    public static void main(String[] args) throws IOException {
        Person person = new Person("pwq","23");
        Person person1 = new Person("gwt","23");
        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("object.txt"));
        oos.writeObject(person);
        oos.writeObject(person1);
        oos.close();

    }
    @Test
    public void readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
        Person p1 = (Person) ois.readObject();
        System.out.println(p1);
        Person p2 = (Person) ois.readObject();
        System.out.println(p2);
        Person p3 = (Person) ois.readObject();
        System.out.println(p3);
    }

}

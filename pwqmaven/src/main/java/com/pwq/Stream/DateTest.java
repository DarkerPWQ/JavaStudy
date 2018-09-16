package com.pwq.Stream;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by pwq on 2018/1/21.
 */
public class DateTest {
    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));
        dataOutputStream.writeInt(997);
        dataOutputStream.writeInt(998);
        dataOutputStream.writeInt(996);
        dataOutputStream.close();
    }
}

package com.pwq.Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * Created by pwq on 2018/1/18.
 */
public class SequenceTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("pom.xml");
        FileInputStream fis1 = new FileInputStream("pwq.txt");
        FileOutputStream fos = new FileOutputStream("seqtest.txt");
        SequenceInputStream sis = new SequenceInputStream(fis,fis1);
        int x;
        while ((x = sis.read())!=-1) {
            fos.write(x);
        }
        fos.close();
        sis.close();

    }
}

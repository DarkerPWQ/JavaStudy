package com.pwq.mavenT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 14:29 2017/8/14
 * @Modified By：
 */
public class ObjectMappingTest {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Student sdt = new Student();
        sdt.setName("濮文强");
        sdt.setSex('y');
        sdt.setYear(199415);
        String json="";
        try {
            json = objectMapper.writeValueAsString(sdt);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        Student student = objectMapper.readValue(json,Student.class);
        System.out.println(student);


    }
}

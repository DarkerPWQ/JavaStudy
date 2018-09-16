package com.pwq.mavenT;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 10:26 2017/11/27
 * @Modified By：
 */
public class systemTest {
    public static void main(String[] args) {
                String fileSeparator = System.getProperties().getProperty("file.separator");
                if(fileSeparator.equals("\\")){
                    System.out.println("等于");
                    System.out.println("\\其实就是一个");
                }
        System.out.println(fileSeparator);
                String osName = System.getProperties().getProperty("os.name");
        System.out.println(osName);
        }
    }


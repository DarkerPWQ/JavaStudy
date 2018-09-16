package com.pwq.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 20:43 2017/8/2
 * @Modified By：
 */
public class TEST {
    public static void main(String[] args) {
        Integer[] a = {3,4,6,47,8,1,2,4,7,9,3,4,16,36,22,78,7,100,55,22,11,44,55,66,62,2626,246247,2,645,7257,672,626,72,46,62,65,26,2233,872,7,36,8,79,8,211,32,12,4,34,332,4,325,31,56,13,56,51,5,34,5};
        InsertSort insertSort = new InsertSort();
        System.out.println(System.currentTimeMillis());
        insertSort.setA(a);

        insertSort.print();
        System.out.println(System.currentTimeMillis());
    }
}

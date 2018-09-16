package com.pwq.sort;

import java.util.Comparator;

/**
 * @Author：WenqiangPu
 * @Description
 * @Date：Created in 19:27 2017/8/2
 * @Modified By：
 */
public class InsertSort {
    private Comparable[] a;
    private int exCount;

    public Comparable[] getA() {
        return a;
    }

    public void setA(Comparable[] a) {
        this.a = a;
    }

    /**
     * @Author: WenqiangPu
     * @Description: 实现交换
     * @param
     * @param i
     * @param j
     * @return:
     * @Date: 19:28 2017/8/2
     *
     */

    public Comparable[] exchange(int i,int j){
        exCount++;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        return a;
    }
    public void insert(){//插入排序
        for(int i = 1;i<a.length;i++){
            for(int j=i;j>0&&a[j].compareTo(a[j-1])<0;j--){
                exchange(j,j-1);
            }
            }
    }
    public void print(){
        choose();
        for(Comparable c:a){
            System.out.print(c);
            System.out.print(" ");
        }
    }

    public void choose(){
        int min;//指向当前最小位置
        for(int i=0;i<a.length;i++){
            min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j].compareTo(a[min])<0){
                    min=j;
                }
            }
            exchange(i,min);
        }
    }



}

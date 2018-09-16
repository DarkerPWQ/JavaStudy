package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/4/7.
 */
public class QueneO<E> {
    private int front;//指向队头的索引
    private int rear;//指向队尾
    private Object[] data;//顺序存储所用的数组
    private int size;//数组长度,而不是使用长度

    public QueneO(int size) {//队列长度初始化
        this.size = size;
        data = new Object[this.size];
    }
    //判断是否为空
    public boolean empty(){
        return rear==front?true:false;
    }
    //添加元素
    public boolean add(E e){
        if(rear==size){//判断存储是否满了
            System.out.println("队列已满");
            return false;
        }else{
            data[rear++] = e;
            size++;
            return true;
        }
    }
    //删除元素
    public E poll(){
        if(empty()){
            System.out.println("队列为空");
            return null;
        }else{
            E value  = (E) data[front];
            if(value==data[front]){
                System.out.println("一样的");
            }
            data[front++] = null;
            return value;
        }
    }
    //返回长度
    public int length(){
        return rear-front;
    }

    public static void main(String[] args) {
        QueneO<Integer> qo = new QueneO<Integer>(10);
        System.out.println(qo.empty());
        for(int i = 0;i<9;i++){
            qo.add(i);
        }
        System.out.println(qo);
        qo.add(33);
        System.out.println(qo.empty());
        qo.add(50);
        qo.add(22);
        System.out.println(qo.length());
        qo.poll();
        System.out.println(qo.length());
    }
}

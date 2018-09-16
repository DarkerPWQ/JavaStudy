package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/4/7.
 */
public class LinkQueue<E> {
    private class Node{
        private E e;
        private Node next;

        public Node(E e, Node next) {
            System.out.println(e.getClass());
            this.e = e;
            this.next = next;
        }

        public Node() {
        }
    }
    private Node front;
    private Node rear;
    private int size;

    public LinkQueue() {
        this.front=null;
        this.rear=null;
        this.size=0;
    }
    public boolean empty(){
        return size==0;
    }
    public boolean add(E e){
        if(empty()){
            this.front = new Node(e,null);
            this.rear = this.front;
        }else{
            this.rear.next = new Node(e,null);
            this.rear = this.rear.next;
        }
        size++;
        return true;
    }
    public Node poll(){
        if(empty()){
            System.out.println("空队列");
            throw new RuntimeException("空队列");
        }else{
            Node value = this.front;
            this.front = this.front.next;
            value.next=null;
            size--;
            return value;

        }
    }
    public int length(){
        return size;
    }
    public Node peek(){
        if(empty()){
            System.out.println("null");

        }
        return front;
    }

    public static void main(String[] args) {
        LinkQueue<String> lq = new LinkQueue<String>();
        lq.add("pwq");
        lq.add("gwt");
        System.out.println(lq.length());
        System.out.println(lq.poll());
        System.out.println(lq.length());


    }

}

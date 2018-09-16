package com.pwq.mavenT;

import com.pwq.utils.RegexUtils;
import com.pwq.utils.StringUtils;

/**
 * Created by BF100500 on 2017/4/6.
 *
 * 在这里我们再来练习一下解决冲突---本地
 这里的山路十八弯哎---远程
 */
public class BinaryTree<E> {
    private TreeNode root;
    public BinaryTree(TreeNode root) {
        this.root = root;
    }
    public void createTree(){
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        this.root.setLeftNode(B);
        this.root.setRightNode(C);
        B.setLeftNode(D);
        D.setRightNode(E);
    }

    public Boolean isEmpty(){//判断是否为空数
        return this.root==null;
    }

    //判断数的高度
    public int height(){
        return height(root);
    }


    public int height(TreeNode treeNode){
        if(null==treeNode){
            return 0;
        }else {
            int i = height(treeNode.getLeftNode());
            int j = height(treeNode.getRightNode());
            return i<j?j+1:i+1;
        }
    }

    //节点数
    public int size(){
        return size(root);
    }

    public int size(TreeNode node){
        if(node!=null){
            return 1+size(node.getLeftNode())+size(node.getRightNode());
        }
        return 0;
    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(TreeNode node){
        if(node!=null){
            System.out.println(node.getKey());
            preOrder(node.getLeftNode());
            preOrder(node.getRightNode());
        }
    }
    //中序遍历
    public void InOrder(){
        InOrder(root);
    }
    public void InOrder(TreeNode node){
        if(node!=null){

            InOrder(node.getLeftNode());
            InOrder(node.getRightNode());
        }
    }
    //前序遍历
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(TreeNode node){
        if(node!=null){
            postOrder(node.getLeftNode());
            postOrder(node.getRightNode());
            System.out.println(node.getKey());
        }
    }



    private static class TreeNode<E>{
        private E key;
        private TreeNode leftNode;
        private TreeNode rightNode;
        private Boolean isNull;

        public TreeNode(E key) {
            this.key = key;
        }

        public E getKey() {
            return key;
        }

        public void setKey(E key) {
            this.key = key;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }

        public Boolean getNull() {
            return isNull;
        }

        public void setNull(Boolean aNull) {
            isNull = aNull;
        }
    }
    public static int timeToSec(String time){
        int finalDuration = 0;
        try{
            //首先判断time是什么格式 00(小)时00分00秒与 00:00:00
            if(StringUtils.contains(time,":")){//00:00:00
                String[] tmp = time.split(":");
                String hour = "";
                String min = "";
                String sec = "";
                if (tmp.length ==3) {//标准格式
                    hour = tmp[0];
                    min = tmp[1];
                    sec = tmp[2];
                } else if (tmp.length ==2) {
                    min = tmp[0];
                    sec = tmp[1];
                } else if(tmp.length ==1) {
                    sec = tmp[0];
                }

                if (StringUtils.isNotBlank(hour)) {
                    finalDuration = Integer.parseInt(hour) * 3600;
                }
                if (StringUtils.isNotBlank(min)) {
                    finalDuration += Integer.parseInt(min) * 60;
                }
                if (StringUtils.isNotBlank(sec)) {
                    finalDuration += +Integer.parseInt(sec);
                }
            }else{//00(小)时00分00秒
                String hour = RegexUtils.matchValue("(\\d+).*?时", time);
                String min = RegexUtils.matchValue("(\\d+)分", time);
                String sec = RegexUtils.matchValue("(\\d+)秒", time);
                if (StringUtils.isNotBlank(hour)) {
                    finalDuration = Integer.parseInt(hour) * 3600;
                }
                if (StringUtils.isNotBlank(min)) {
                    finalDuration += Integer.parseInt(min) * 60;
                }
                if (StringUtils.isNotBlank(sec)) {
                    finalDuration += +Integer.parseInt(sec);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
        return finalDuration;
    }




    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        BinaryTree bt = new BinaryTree(A);
        bt.createTree();
        System.out.println(bt.height());
        System.out.println(bt.size());
//        bt.preOrder();
//        bt.InOrder();
//        bt.postOrder();
    }
}

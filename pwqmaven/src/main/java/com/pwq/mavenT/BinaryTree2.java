package com.pwq.mavenT;

/**
 * Created by BF100500 on 2017/4/6.
 * 看我神威
 */
public class BinaryTree2 {
    private TreeNode root;

    public BinaryTree2(TreeNode root) {
        this.root = root;
    }
    public void createBinary(){
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        this.root.setLeftNode(B);
        B.setLeftNode(C);
        B.setRightNode(D);
        C.setLeftNode(E);
        E.setRightNode(F);
    }

    //高度
    public int height(){
        return height(root);
    }
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }else{
            int i = height(node.getLeftNode());
            int j = height(node.getRightNode());
            return i<j?j+1:i+1;
        }
    }

    //节点数

    public int size(){
        return size(root);
    }
    public int size(TreeNode node){
        if(node==null){
            return 0;
        }else{
            return 1+size(node.getRightNode())+size(node.getLeftNode());
        }
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
    private static class TreeNode{
        private int key;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
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
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        BinaryTree2 bt = new BinaryTree2(A);
        bt.createBinary();
        bt.height();
        bt.size();
        bt.preOrder();
    }

}

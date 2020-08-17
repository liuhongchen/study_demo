package com.d07_bbst;

/**
 * ClassName:BinaryTree
 * Package:com.d07_bbst
 * Description:
 *
 * @date:2020-01-17 09:20
 * @author:892698613@qq.com
 */
public class BinaryTree<E> {

    private int size;

    private Node root;


    public BinaryTree(E val) {
        root=new Node(val);
        size=1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void clear(){
        root=null;
    }


    public static class Node<E>{

        Node<E> left;
        Node<E> right;

        E val;

        public Node(E val) {
            this.val = val;
        }

    }
}

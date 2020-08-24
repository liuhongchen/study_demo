package com.d06_bst;

import java.util.Comparator;

/**
 * ClassName:BinarySearchTree
 * Package:com.d05_bst
 * Description:
 *
 * @date:2020-01-06 15:31
 * @author:892698613@qq.com
 */
public class BinarySearchTree<E> {

    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public boolean constains(E element) {
        Node<E> temp = root;
        while (temp != null) {
            int cmp = compare(element, temp.element);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public void remove(E element) {
        Node<E> node = findNode(element);
        remove(node);
    }
    public void remove(Node<E> node){
        if(node.hasTwoChild()){
            remove2(node);
        }else{
            remove01(node);
        }
    }

    public void remove01(Node<E> node){
        if (node.parent==null&&root.isLeaf()){
            root=null;
            return;
        }else {
            if (node.parent.left == node) {
                node.parent.left = node.left != null ? node.left : node.right;
            } else {
                node.parent.right = node.left != null ? node.left : node.right;
            }
        }
    }
    private void remove2(Node<E> node) {
        Node<E> cessor=node.left!=null?predecessor(node):successor(node);
        if (cessor==null){
            root=null;
            return;
        }
        node.element=cessor.element;
        remove01(cessor);
    }
    public Node<E> findNode(E element){
        Node<E> dummy=root;
        int cmp;
        while (dummy!=null){
            cmp=compare(element,root.element);
            if(cmp==0){
                return dummy;
            }else if (cmp>0){
                dummy=dummy.right;
            }else{
                dummy=dummy.left;
            }
        }
        return null;
    }

    public void add(E element) {
        elementNotNullCheck(element);

        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        Node<E> temp = root;
        Node parent = temp;
        int cmp = 0;
        while (temp != null) {
            cmp = compare(element, temp.element);
            parent = temp;
            if (cmp == 0) {
                //这个地方不要直接return,例如两个不同的Person但是年龄相等
                Node<E> newNode = new Node<>(element, temp.parent);
                if (compare(temp.element, temp.parent.left.element) == 0) {
                    temp.parent.left = newNode;
                } else {
                    temp.parent.right = newNode;
                }
                return;
            } else if (cmp < 0) {
                temp = temp.left;

            } else {
                temp = temp.right;
            }
        }
        if (cmp > 0) {
            parent.right = new Node(element, parent);
        } else {
            parent.left = new Node(element, parent);
        }

    }

    private int compare(E e1, E e2) {
        int cmp;
        if (comparator != null) {
            cmp = comparator.compare(e1, e2);
        } else {
            cmp = ((Comparable<E>) (e1)).compareTo(e2);
        }
        return cmp;

    }

    /**
     * 前驱结点,先判断左子树是否为空
     *      为空:找parent,直到找到node是父节点的右子树
     *      不为空:先left一次,然后一直right到底
     * @param node
     * @return
     */
    public Node predecessor(Node<E> node){
        if (node==null||(node.left==null&&node.parent==null))return null;
        if (node.left!=null){
            node=node.left;
            Node parent=node;
            while (node!=null){
                parent=node;
                node=node.right;
            }
            return parent;
        }else {
            while (true){
                if (node.parent.right==node)return node.parent;
                node=node.parent;
            }
        }

    }

    public Node successor(Node<E> node){
        if (node==null||(node.right==null&&node.parent==null))return null;
        if (node.right!=null){
            node=node.right;
            Node parent=node;
            while (node!=null){
                parent=node;
                node=node.left;
            }
            return parent;
        }else {
            while (true){
                if (node.parent.left==node)return node.parent;
                node=node.parent;
            }
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) throw new IllegalArgumentException("传入元素不能为空");
    }

    public int size() {
        return size;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        boolean isLeaf(){
            return left==null&&right==null;
        }

        boolean hasTwoChild(){
            return left!=null&&right!=null;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((o1, o2) -> o1 - o2);

    }
}

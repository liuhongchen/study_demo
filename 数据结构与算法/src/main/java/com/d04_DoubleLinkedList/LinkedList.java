package com.d04_DoubleLinkedList;


/**
 * ClassName:LinkedList
 * Package:com.demo.d_04_DoubleLinkedList
 * Description:
 *
 * @date:2019-12-10 18:08
 * @author:892698613@qq.com
 */
@SuppressWarnings("unchecked")
public class LinkedList<E> {


    private int size = 0;
    private Node<E> first;
    private Node<E> last;


    public Node get(int index) {
        int mid = size / 2;
        if (size == 0) return null;
        if (index == 0) return first;
        if (index == size - 1) return last;

        if (index <= mid) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node temp = last;
            int count = size - 1 - index;
            for (int i = 0; i < count; i++) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    public void add(E val) {
        add(0, val);
    }

    public void add(int index, E val) {
        Node<E> node = new Node(val);
        if (index == 0) {
            if (size != 0) {
                node.next = first;
                first.prev = node;
            }else{
                last=node;
            }
            first = node;
        } else if (index == size ) {//这是在最后一个的后面添加
            node.prev = last;
            last.next = node;
            last = node;
        } else {
            Node oldNode = get(index);
            node.prev = oldNode.prev;
            oldNode.prev.next = node;
            node.next = oldNode;
            oldNode.prev = node;
        }
        size++;
    }

    public E remove(int index){
        Node node = get(index);
        if (index>=size) return null;
        if (index==0){
            if (node.next!=null){
                node.next.prev=null;
                first=node.next;
            }
        }else if (index==size-1){//最后一个
            node.prev.next=null;
            last=node.prev;
            node.prev=null;
        }else {
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }
        size--;
        return (E) node.val;
    }

    public void clear(){
        this.last=null;
        this.first=null;
        size=0;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1,4);
        list.add(2,0);
        System.out.println(list);
        System.out.println(list.get(0).val);
        System.out.println(list.get(1).val);
        System.out.println(list.get(2).val);
        System.out.println(list.get(3).val);
        System.out.println(list.get(4).val);
        Object remove = list.remove(0);
        System.out.println("删除了"+remove);
        System.out.println(list);
    }

    class Node<E> {
        Node<E> prev;
        Node<E> next;
        E val;


        public Node(E val) {
            this.val = val;
        }
    }
}

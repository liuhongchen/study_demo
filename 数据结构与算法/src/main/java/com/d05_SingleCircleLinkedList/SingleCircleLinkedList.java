package com.d05_SingleCircleLinkedList;

/**
 * ClassName:SingleCircleLinkedList
 * Package:com.d05_SingleCircleLinkedList
 * Description:
 *
 * @date:2019-12-10 20:25
 * @author:892698613@qq.com
 */
public class SingleCircleLinkedList<E> {


    public int size=0;
    public Node head;


    public Node get(int index){
        if (index<0||index>=size)return null;
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }

    public void add(E val){
        add(0,val);
    }

    public void add(int index,E val){
        Node node=new Node(val);
        if (index==0){
            node.next=head;
            head=node;
            size++;
            get(size-1).next=head;
        }else if (index==size){//这个是在最后一个的后面添加的情况
            get(size-1).next=node;
            node.next=head;
            size++;
        }else {
            Node oldPrev = get(index - 1);
            Node old = oldPrev.next;
            oldPrev.next = node;
            node.next = old;
            size++;
        }
    }


    public void remove(int index){
        if(index>=size) return;
        if(index==0){
            head=head.next;
            get(size-1).next=head;
        }else{
            Node nodePre = get(index - 1);
            nodePre.next=nodePre.next.next;
        }

        size--;
    }


    public class Node<E> {
        public E val;
        public Node<E> next;
        public Node(E val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        SingleCircleLinkedList list=new SingleCircleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.get(0).val);
        System.out.println(list.get(1).val);
        System.out.println(list.get(2).val);
        list.remove(1);
        System.out.println(list);
    }

}

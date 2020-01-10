package com.d03_LinkedList;


@SuppressWarnings("unchecked")
public class LinkedList<E> {

    private int size;
    private Node<E> firstNode;


    public void add(E value){

        Node node=new Node(value,null);
        node.next=firstNode;
        firstNode=node;
        size++;
    }

    public void add(int index,E value){
        if (index==0) add(value);
        Node newNode=new Node(value,null);
        Node beforeOldNode=getNode(index-1);
        newNode.next=beforeOldNode.next;
        beforeOldNode.next=newNode;
        size++;

    }

    public E remove(int index){

        E old;
        if (index==0) {
            old=firstNode.value;
            firstNode=firstNode.next;
        }
        Node<E> beforeNode=getNode(index-1);
        old=beforeNode.next.value;
        beforeNode.next=beforeNode.next.next;
        size--;
        return old;
    }


    public E getValue(int index){
        return getNode(index).value;
    }


    public Node<E> getNode(int index){
        Node node=firstNode;
        int i=0;
        while (i<index){
            node=node.next;
            i++;
        }

        return node;

    }

    public void setValue(int index,E value){
        getNode(index).value=value;
    }


    public int indexOf(E value){
        Node<E> node=firstNode;
        if (value==null){
            for (int i=0;i<size;i++){
                if (node.value==null) return i;
                node=node.next;
            }
        }else{
            for (int i=0;i<size;i++){
                if (node.value.equals(value)) return i;
                node=node.next;
            }
        }

        return -1;

    }
    public void clear(){
        size=0;
        firstNode=null;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("size:"+size+",[");
        Node<E> node=firstNode;
        for (int i=0;i<size-1;i++){
            sb.append(node.value+",");
            node=node.next;
        }
        sb.append(node.value+"]");
        return sb.toString();
    }

    private static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}

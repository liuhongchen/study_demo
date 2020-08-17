package 考研.栈与队列.队列.链式结构;


import 考研.线性表.链式表示.Node;

public class LinkedQueue {//尾插


    public Node head;
    public Node last;


    public LinkedQueue(int val) {
        head=new Node(val);
        last=head;
    }


    public void enQueue(int val){
        last.next=new Node(val);
        last=last.next;
    }

    public Integer deQueue(){
        if (head==null)return null;
        int val=head.val;
        Node rest=head.next;
        head.next=null;
        head=rest;
        if (head==null)last=null;
        return val;
    }

    public Boolean isEmpty(){
        return head == null;
    }

    
}

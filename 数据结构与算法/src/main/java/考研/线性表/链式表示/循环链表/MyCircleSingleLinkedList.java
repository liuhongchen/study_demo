package 考研.线性表.链式表示.循环链表;

public class MyCircleSingleLinkedList {


    public Node head;


    public MyCircleSingleLinkedList(Integer val) {
        head=new Node(val);
        head.next=head;
    }





    public static class Node{

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}

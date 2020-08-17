package 考研.线性表.链式表示.双链表;

public class MyDoubleLinkedList {



    public Node head;
    public Node last;


    public MyDoubleLinkedList(int val){
        head=new Node(val);
        last=head;
    }


    public void insertPre(Node node,int val){
        Node newNode=new Node(val);
        node.prev.next=newNode;
        newNode.next=node;


    }






    public static class Node{

        Node prev;
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node prev, int val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }
}

package 考研.线性表.链式表示.单链表;

public class MySingleLinkedList {


    public Node head;
    public Node last;
    public int size;

    public MySingleLinkedList(int val){
        head=new Node(val);
        last=head;
        size=1;
    }

    public void addHead(int val){
        head= new Node(val, head);
        size++;
    }

    public void addTail(int val){
        last.next= new Node(val);
        last=last.next;
        size++;
    }

    //传入要找第几个，不是index
    public Integer findByCount(int count){
        if (count>size||count<0)return null;
        Node node=head;
        for (int i = 0; i < count-1; i++) {
            node=node.next;
        }
        return node.val;
    }


    public Node findNodeByVal(int val){
        Node node=head;
        while (node!=null){
            if (node.val==val)return node;
            node=node.next;
        }
        return null;
    }

    public void insert(int index,int val){
        if (index>=size||index<0)return;
        Node node=head;
        for (int i = 0; i < index-1; i++) {
            node=node.next;
        }
        Node newNode=new Node(val,node.next.next);
        node.next=newNode;
        size++;
    }

    public Integer deleteByIndex(int index){
        if (index<0||index>=size)return null;
        Node node=head;
        for (int i = 0; i < index - 1; i++) {
            node=node.next;
        }
        Integer val=node.next.val;
        node.next=node.next.next;
        return val;
    }


    public int getSize(){
        return size;
    }


    public static class Node{
        Integer val;
        Node next;


        public Node() {
        }

        public Node(Integer val) {
            this.val = val;
        }
        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }

    }
}

package demo.d03_LinkedList.test;


import demo.d03_LinkedList.ListNode;

public class LeetCode237 {



    public void deleteNode(ListNode node) {

        node.val=node.next.val;
        node.next=node.next.next;
    }

    public static void main(String[] args) {

    }



}

package 练习.链表;

import demo.d03_LinkedList.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class _19_删除链表中的倒数第n个节点 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size=0;
        while (temp!=null){
            size++;
            temp=temp.next;
        }

        ListNode newListNode=new ListNode(-1);
        temp=newListNode;
        for (int i=0;i<size;i++){
            if (i==size-n) {
                head=head.next;
                continue;
            }else{
                temp.next=new ListNode(head.val);
                head=head.next;
                temp=temp.next;
            }

        }
        newListNode=newListNode.next;
        return newListNode;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next=new ListNode(3);
        l2.next.next.next=new ListNode(4);
        l2.next.next.next.next=new ListNode(5);
        ListNode listNode = removeNthFromEnd(l2, 2);
        System.out.println(listNode);
    }

}

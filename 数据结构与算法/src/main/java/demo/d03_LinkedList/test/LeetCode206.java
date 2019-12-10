package demo.d03_LinkedList.test;

import demo.d03_LinkedList.ListNode;
import org.junit.Test;

/**
 * ClassName:LeetCode206
 * Package:demo.d03_LinkedList.test
 * Description: 翻转链表
 *
 * @date:2019-11-27 15:11
 * @author:892698613@qq.com
 */

public class LeetCode206 {





    public ListNode reverseList(ListNode head){
        ListNode newHead=new ListNode(head.val);
        while (head.next!=null){
            head=head.next;
            System.out.println(head.val);
            newHead.next=newHead;
            newHead.val=head.val;
        }
        return newHead;
    }


    @Test
    public void test(){
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);

        ListNode result = reverseList(listNode);
        System.out.println(result);


    }

}

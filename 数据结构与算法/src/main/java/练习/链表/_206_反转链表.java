package 练习.链表;

import com.d03_LinkedList.ListNode;

/**
 * ClassName:LeetCode206
 * Package:com.d03_LinkedList.test
 * Description: 翻转链表
 *
 * @date:2019-11-27 15:11
 * @author:892698613@qq.com
 */

public class _206_反转链表 {





    public ListNode reverseList(ListNode head){
        if (head==null||head.next==null)return head;
        ListNode prev=null;
        ListNode cur=head;

        while (cur!=null){
            ListNode third=cur.next;
            cur.next=prev;
            prev=cur;
            cur=third;
        }

        return prev;

    }




}

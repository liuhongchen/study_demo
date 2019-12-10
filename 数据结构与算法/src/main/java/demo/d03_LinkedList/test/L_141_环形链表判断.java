package demo.d03_LinkedList.test;

import demo.d03_LinkedList.ListNode;

/**
 * ClassName:LeetCode141
 * Package:demo.d03_LinkedList.test
 * Description:
 *
 * @date:2019-11-27 16:25
 * @author:892698613@qq.com
 */
public class L_141_环形链表判断 {


    public class Solution {


        public boolean hasCycle(ListNode head) {
            if (head==null||head.next==null) return false;

            ListNode slow=head;
            ListNode fast=head.next;
            while (fast!=null&&fast.next!=null){
                if(slow==fast)return true;
                slow=slow.next;
                fast=fast.next.next;
            }

            return false;
        }
    }
}

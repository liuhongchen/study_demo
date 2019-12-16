package 练习.链表;

import demo.d03_LinkedList.ListNode;

public class L_234_回文链表 {

    public static boolean isPalindrome(ListNode head) {
        if (head==null|| head.next == null) return true;

        ListNode slow = head, fast = head;

        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }

        if(fast != null) {
            slow = slow.next;
        }

        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;


    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(listNode));
    }
}

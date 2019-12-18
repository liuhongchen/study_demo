package 练习.链表;


/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 要实际交换节点，而不是仅仅交换值
 */

import demo.d03_LinkedList.ListNode;

public class L_24_两两交换链表中的值 {


    /**
     * 方法一：创建新链
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head==null) return null;

        ListNode result=new ListNode(-1);
        ListNode temp=result;
        while (head!=null){
            if (head.next==null){
                temp.next=new ListNode(head.val);
                break;
            }

            temp.next=new ListNode(head.next.val);
            temp=temp.next;
            temp.next=new ListNode(head.val);
            temp=temp.next;
            head=head.next.next;
        }

        return result.next;


    }

    /**
     * 方法二：自身交换/仅仅交换值
     */

    public ListNode swapPairs2(ListNode head) {
        if (head==null)return null;
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null){
            int temp=fast.val;
            fast.val=slow.val;
            slow.val=temp;
            slow=slow.next.next;
            if (fast.next==null)break;
            fast=fast.next.next;
        }
        return head;
    }

    /**
     * 自身交换，交换节点,这个结果还不对
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {
        if (head==null)return null;
        ListNode backup=head;

        while (head!=null){
            if (head.next==null) break;

            ListNode slow=head;
            ListNode fast=head.next;
            ListNode temp=fast.next;
            fast.next=slow;
            slow.next=temp;
            head=fast;
            head=head.next.next;

        }
        return backup;
    }

}

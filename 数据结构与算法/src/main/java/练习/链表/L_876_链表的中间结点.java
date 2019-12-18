package 练习.链表;

import demo.d03_LinkedList.ListNode;

/**
 * ClassName:L_876_链表的中间结点
 * Package:demo.d03_LinkedList.test
 * Description:
 *
 * @date:2019-12-10 13:52
 * @author:892698613@qq.com
 */
public class L_876_链表的中间结点 {
    public ListNode middleNode1(ListNode head) {
        if (head == null) return null;
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int mid = length / 2;//从0开始计数,中间结点索引值,也是next的次数
        for (int i = 0; i < mid; i++) {
            head = head.next;
        }
        return head;
    }

    //使用快慢指针
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast!=null) {
            if (fast.next==null){
                slow=slow.next;
                return slow;
            }else {
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return slow;
    }
}

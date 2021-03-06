package 练习.链表;

import com.d03_LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;


public class _142_环形链表2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode temp = head;
        Set<ListNode> set = new HashSet<ListNode>();
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            } else {
                set.add(temp);
                temp = temp.next;
            }
        }

        return null;

    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;

            if (fast == slow) {
                ListNode encounter = fast;
                while (true){
                    if (encounter==head)return encounter;
                    encounter=encounter.next;
                    head=head.next;
                }
            }
        }
        return null;

    }
}
package 练习.链表;

import com.d03_LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class _92_反转链表2 {


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i < m; i++) {
            arrayList.add(head.val);
            head = head.next;
        }

        int count = n - m + 1;
        return reverse(head, arrayList, count);


    }

    public static ListNode reverse(ListNode head, ArrayList<Integer> list, int count) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode n3 = null;
        while (head != null) {
            if (count == 0) {
                n3 = head;
                break;
            }
            arrayList.add(head.val);
            head = head.next;
            count--;
        }
        Collections.reverse(arrayList);
        list.addAll(arrayList);
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (Integer i : list) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = n3;
        return dummy.next;
    }


    public ListNode reverseBetween2(ListNode head, int m, int n) {

        if (head == null) return null;
        if (m == n) return head;

        ListNode prev = null;
        ListNode cur = head;


        for (int i = 1; i < m; i++) {
            if (prev == null) {
                prev = head;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }

        ListNode con = prev;
        ListNode tail = cur;


        for (int i = m; i <= n; i++) {
            ListNode third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;


        return head;
    }
}
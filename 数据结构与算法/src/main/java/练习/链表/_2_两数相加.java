package 练习.链表;

import demo.d03_LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:L_2_两数相加
 * Package:demo.d06_LinkedList练习
 * Description:https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @date:2019-12-10 22:39
 * @author:892698613@qq.com
 */
public class _2_两数相加 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null)return null;
        List<Integer> list=new ArrayList();
        int temp = 0;
        while (l1 != null||l2!=null) {
            int sum = temp+(l1==null?0:l1.val) + (l2==null?0:l2.val);
            if (sum >= 10) {
                sum -= 10;
                temp = 1;
            } else {
                temp=0;
            }
            list.add(sum);
            if (l1!=null)l1 = l1.next;
            if (l2!=null)l2 = l2.next;
        }
        if (temp > 0) list.add(1);
        System.out.println(list);
        ListNode result =new ListNode(list.get(0));
        ListNode t=result;
        for (int i=1;i<list.size();i++){
            t.next=new ListNode(list.get(i));
            t=t.next;
        }
        return result;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next=new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result.val);
        System.out.println(result.next.val);
//        System.out.println(result.next.next.val);
    }


}

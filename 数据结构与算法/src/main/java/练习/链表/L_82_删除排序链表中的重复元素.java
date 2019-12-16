package 练习.链表;

import demo.d03_LinkedList.ListNode;

import java.util.*;

public class L_82_删除排序链表中的重复元素 {


    /**
     * 方法一：LinkedHashMap，顺便统计出现次数，在创建新ListNode 的时候只加value=1的
     * 要用LinkedHashMap保证顺序
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null)return head;

        Map<Integer,Integer> map=new LinkedHashMap<Integer, Integer>();


        for (ListNode temp=head;temp!=null;temp=temp.next){
            if (map.containsKey(temp.val)){
                map.put(temp.val,map.get(temp.val)+1);
            }else{
                map.put(temp.val,1);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;

        Set<Integer> keys = map.keySet();

        for (Integer key:keys){
            if (map.get(key)==1){
                temp.next=new ListNode(key);
                temp=temp.next;
            }
        }

        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head){
        if (head==null||head.next==null)return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;


        ListNode slow=dummy;
        ListNode fast=dummy.next.next;

        int count=0;
        while (fast!=null){
            if (slow.next.val==fast.val){
                count++;
                fast=fast.next;
            }else{
                if (count>=1) {
                    slow.next = fast;
                    fast = fast.next;
                    count = 0;
                }else{
                    slow=slow.next;
                    fast=fast.next;
                }
            }
        }

        if (count>0){
            slow.next = null;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode listNode=new ListNode(2);
        listNode.next=new ListNode(1);
        deleteDuplicates2(listNode);
    }
}

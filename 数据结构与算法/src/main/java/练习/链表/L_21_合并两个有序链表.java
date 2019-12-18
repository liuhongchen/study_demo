package 练习.链表;

import demo.d03_LinkedList.ListNode;

public class L_21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode result=new ListNode(-1);
        ListNode temp=result;

        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                temp.next=new ListNode(l1.val);
                l1= l1.next;
            }else{
                temp.next=new ListNode(l2.val);
                l2=l2.next;
            }
            temp=temp.next;
        }

        temp.next=(l1==null)?l2:l1;
        result=result.next;
        return result;
    }

}

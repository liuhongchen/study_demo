package 练习.链表;

import demo.d03_LinkedList.ListNode;

/**
 * ClassName:L_86_分隔链表
 * Package:练习
 * Description:
 *
 * @date:2019-12-15 16:22
 * @author:892698613@qq.com
 */
public class _86_分隔链表 {

    public static ListNode partition(ListNode head, int x) {
        if (head==null||head.next==null) return head;
        ListNode t=head;
        ListNode xPrev=null;
        ListNode xNode=null;
        while (t!=null){
            if (t.val==x){
                xNode=t;
                break;
            }
            xPrev=t;
            t=t.next;
        }
        if (xNode==null) return head;
        t=xNode;
        while (t!=null){
            if (t.val<x){
                ListNode temp=head;
                while (temp!=xNode){
                    if (temp.val<=t.val&&t.val<=temp.next.val){
                        ListNode tempNext=temp.next;
                        ListNode newT = new ListNode(t.val);
                        temp.next=newT;
                        newT.next=tempNext;
//                        if (t.next!=null){
//                            xPrev.next=xPrev.next.next;
//                            xPrev=xPrev.next;
//                        }
                        xPrev.next=t.next;
                        t=t.next;
//                        if (xPrev!=null)xPrev=xPrev.next;
                        System.out.println(1);
                        break;
                    }
                    temp=temp.next;
                }
            }
            t=t.next;
            if (xPrev==null){
                xPrev=head;
            }else {
                xPrev = xPrev.next;
            }
            System.out.println("hello");
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next= new ListNode(5);
        listNode.next.next.next.next.next= new ListNode(2);
        listNode.next.next.next.next.next.next= new ListNode(2);
        partition(listNode, 3);
    }
}

package 练习.链表;

import demo.d03_LinkedList.ListNode;

/**
 * ClassName:L_203_移除链表元素
 * Package:demo.d03_LinkedList.test
 * Description:
 *
 * @date:2019-12-10 12:14
 * @author:892698613@qq.com
 */
public class _203_移除链表元素 {


    public static ListNode removeElements(ListNode head, int val) {
        if (head==null)return null;
        ListNode listNode=new ListNode(-1);
        ListNode temp=listNode;
        while (head!=null){
            if (head.val!=val){
                temp.next=new ListNode(head.val);
                temp=temp.next;
            }
            head=head.next;
        }
        listNode=listNode.next;
        return listNode;


    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(4);
        ListNode listNode4=new ListNode(5);
        ListNode listNode5=new ListNode(6);

        listNode4.next=listNode5;
        listNode3.next=listNode4;
        listNode2.next=listNode3;
        listNode1.next=listNode2;
        listNode.next=listNode1;

        removeElements(listNode,2);
    }
}

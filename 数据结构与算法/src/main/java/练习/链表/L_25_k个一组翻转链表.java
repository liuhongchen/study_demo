package 练习.链表;

import demo.d03_LinkedList.ListNode;

/**
 * ClassName:L_25_k个一组翻转链表
 * Package:练习
 * Description:
 *
 * @date:2019-12-15 15:01
 * @author:892698613@qq.com
 */
public class L_25_k个一组翻转链表 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1) return head;
        ListNode temp=head;
        int size=0;
        while (temp!=null){
            size++;
            temp=temp.next;
        }

        if(size<k)return head;
        int count = size / k;
        ListNode prev=null;
        ListNode cur=head;
        ListNode con=null;
        ListNode tail=cur;
        for(int i=0;i<count;i++){
            for(int j=0;j<k;j++){
                ListNode third=cur.next;
                cur.next=prev;
                prev=cur;
                cur=third;
            }
            if(con==null){
                head=prev;
            }else{
                con.next=prev;
            }

            con=tail;
            if(i<count-1) tail=cur;
        }
        if (tail!=null) tail.next=cur;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next= new ListNode(5);
        reverseKGroup(listNode,2);
    }
}

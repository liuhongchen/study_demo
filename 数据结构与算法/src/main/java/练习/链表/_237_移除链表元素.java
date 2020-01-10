package 练习.链表;


import com.d03_LinkedList.ListNode;

public class _237_移除链表元素 {



    public void deleteNode(ListNode node) {
        if (node==null) return;
        node.val=node.next.val;
        node.next= node.next.next;

    }

    public static void main(String[] args) {

    }



}

package 练习.链表;


import demo.d03_LinkedList.ListNode;

import java.util.Stack;

public class L_61_旋转链表 {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;


        //这里需要获取倒数第k个节点的前一个，也就是获取倒数k+1个，然后获取k的话直接next
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;

        for (int i = 0; i < k + 1; i++) {
            if (fast == null) fast = head;
            last = fast;
            fast = fast.next;

        }

        while (fast != null) {
            slow = slow.next;
            last = fast;
            fast = fast.next;
        }
        //此时的slow就是倒数第k+1个节点


        //获取倒数第k到最后的部分
        ListNode before = slow.next;
        if (before == null) return head;

        //把slow的后面设为null
        slow.next = null;

        //把slow后面那段拼接在head的前面
        last.next = head;

        return before;


    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next= new ListNode(5);
        rotateRight3(listNode, 2);
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;

        //这里需要获取倒数第k个节点的前一个，也就是获取倒数k+1个，然后获取k的话直接next
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;

        for (int i = 0; i < k + 1; i++) {
            if (fast == null) fast = head;
            last = fast;
            fast = fast.next;

        }

        while (fast != null) {
            slow = slow.next;
            last = fast;
            fast = fast.next;
        }
        last.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static ListNode rotateRight3(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 0) return head;

        int size=0;
        for (ListNode temp=head;temp!=null;temp=temp.next){
            size++;
        }

        Stack<Integer> stack=new Stack();
        int count=size-k-1;
        for (int i=0;i<count;i++){
            stack.push(head.val);
            head=head.next;
        }
        head=head.next;
        ListNode before=new ListNode(stack.pop());
        ListNode temp=before;
        while (stack.size()>0){
            temp.next=new ListNode(stack.pop());
            temp=temp.next;
        }
        before.next=head;
        return head;
    }
}

package 练习.栈;

import com.d03_LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class _1019_链表中的下一个更大节点 {

    public static int[] nextLargerNodes(ListNode head) {
        if(head==null)return null;
        ArrayList<Integer> arrayList=new ArrayList<>();
        while (head!=null){
            arrayList.add(head.val);
            head=head.next;
        }

        Stack<Integer> stack=new Stack<>();
        int len=arrayList.size();
        int[] res=new int[len];
        for (int i=0;i<len;i++) {
            int num=arrayList.get(i);
            while (stack.size() > 0 && arrayList.get(stack.peek()) <num ) {
                Integer popIndex = stack.pop();
                res[popIndex] = num;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(2);
        listNode.next=new ListNode(1);
        listNode.next.next=new ListNode(5);
        System.out.println(nextLargerNodes(listNode));
    }
}

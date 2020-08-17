package 考研.栈与队列.栈;

import org.junit.Test;

import java.util.Stack;

public class Qs {


    /**
     * P71 3.2
     */
    public Boolean q3_2(String str){
        char[] chars = str.toCharArray();
        int res=0;
        for (char c : chars) {
            if (c=='I'){
                res++;
            }else{
                res--;
            }
            if (res<0)return false;
        }
        return res==0;
    }

    @Test
    public void test3_2(){
        String str="IIIOIOIO";
        System.out.println(q3_2(str));
    }

    public static class Node {
        public Character val;
        public Node next;

        public Node(Character val) {
            this.val = val;
        }

    }

    /**
     * 测试单链表是否中心对称xyx、xyyx
     */
    public Boolean q4(Node node,int n){
        if (n==0||n==1)return true;

        Stack<Character> stack=new Stack<Character>();

        int mid=n/2;

        for (int i = 0; i < mid; i++) {
            stack.push(node.val);
            node=node.next;
        }
        if (n%2!=0)node=node.next;

        while (node!=null){
            Character pop = stack.pop();
            if (pop!=node.val)return false;
            node=node.next;
        }
        return true;

    }

    @Test
    public void test4(){

        Node node=new Node('a');
        node.next=new Node('b');
        node.next.next=new Node('c');
        node.next.next.next=new Node('b');
        node.next.next.next.next=new Node('a');

        System.out.println(q4(node, 5));
    }

}

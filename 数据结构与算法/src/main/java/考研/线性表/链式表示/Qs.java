package 考研.线性表.链式表示;


import org.junit.Test;
import utils.MyUtil;

import java.util.*;

public class Qs {

    /**
     * P40 1 递归算法，删除不带头结点的单链表L中所有值为x的结点
     */
    public void q1(Node node,int x){


        if (node==null)return;
        if (node.val==x){
            node=node.next;
             q1(node,x);
        }else{
            q1(node.next,x);
        }

    }

    @Test
    public void test1(){
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);

         q1(node, 2);
        MyUtil.printNode(node);
    }


    /**
     * 在带头结点的单链表L中，删除所有值为x的结点，并释放其空间，假设值为x的结点不唯一
     */
    public void q2(Node head,int x){
        Node prev=head;
        Node node=head.next;

        while (node!=null){
            if (node.val==x){
                prev.next=node.next;
                node=node.next;
            }else{
                prev=node;
                node=node.next;
            }
        }

    }

    @Test
    public void test2(){
        Node node=new Node(3);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);

        Node dummy=new Node();
        dummy.next=node;

        q2(dummy,3);
        MyUtil.printNode(dummy);

    }


    /**
     * 反向遍历带头结点的单链表
     */
    public void q3_1(Node dummy){
        Node node=dummy.next;
        Stack<Integer> stack=new Stack<Integer>();

        while (node!=null){
            stack.push(node.val);
            node=node.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }


    }

    public void q3_2(Node node){

        if (node.next!=null){
            q3_2(node.next);
        }
        System.out.println(node.val);
    }

    @Test
    public void test3(){
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);

        Node dummy=new Node();
        dummy.next=node;

//        q3_1(dummy);
        q3_2(dummy);

    }


    /**
     * 删除带头结点的单链表中的最小节点
     */
    public void q4(Node dummy){
        Node minPrev=dummy;//默认除虚拟头的第一个节点为最小值，然后比较
        Node prev=dummy;
        Node node=dummy.next;

        while (node!=null){
            if (node.val<minPrev.next.val){
                minPrev=prev;
            }
            prev=node;
            node= node.next;
        }

        minPrev.next=minPrev.next.next;
    }


    @Test
    public void test4(){
        Node node=new Node(4);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(1);

        Node dummy=new Node();
        dummy.next=node;

        q4(dummy);
        MyUtil.printNode(dummy);
    }


    /**
     * 将带头结点的单链表原地逆置（辅助空间复杂度O(1))  (重要）
     */
    public void q5_1(Node dummy){
//        Node node=dummy.next;

        if (dummy.next==null)return;

        Node prev=dummy.next;
        Node node=prev.next;
        Node next=(node!=null)?node.next:null;

        prev.next=null;
        while (node!=null){
            node.next=prev;
            prev=node;
            node=next;
            if (next!=null)next=next.next;
        }

        dummy.next=prev;

    }

    public Node q5_2(Node dummy){

        Node newNode=new Node();

        while (dummy.next!=null){
            Node temp=dummy.next.next;
            Node rest=newNode.next;
            newNode.next=dummy.next;
            newNode.next.next=rest;
            dummy.next=temp;
        }
        return newNode;

    }

    @Test
    public void test5(){
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);

        Node dummy=new Node();
        dummy.next=node;

        Node node1 = q5_2(dummy);
        MyUtil.printNode(node1);
    }


    /**
     * 给带头结点的单链表排序，递增
     */
    public Node q6(Node dummy){
        Node node=dummy.next;
        if (node==null)return dummy;

        ArrayList<Integer> list=new ArrayList<Integer>();
        while (node!=null){
            list.add(node.val);
            node=node.next;
        }
        Collections.sort(list);

        node=dummy.next;//存下新node的指针

        Node work=node;
        for (Integer val : list) {
            work.val=val;
            work=work.next;
        }
        dummy.next=node;
        return dummy;
    }


    @Test
    public void q6(){
        Node node=new Node(8);
        node.next=new Node(2);
        node.next.next=new Node(7);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(3);

        Node dummy=new Node();
        dummy.next=node;

        Node node1 = q6(dummy);
        MyUtil.printNode(node1);
    }

    /**
     * 删除带头结点的无序单链表中 值介于m和n之间的结点
     */
    public void q7(Node dummy,int m,int n){
        if (m>n)return;
        Node prev=dummy;
        Node work=dummy.next;

        while (work!=null){
            if (work.val>=m&&work.val<=n){
                prev.next=work.next;
                work=work.next;
            }else{
                prev=work;
                work=work.next;
            }
        }

    }

    @Test
    public void test7(){
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);

        Node dummy=new Node();
        dummy.next=node;

        q7(dummy,1,5);
        MyUtil.printNode(dummy);

    }

    /**
     * 找出两个单链表的公共结点
     */
    public Set<Integer> q8(Node node1,Node node2){//错误解法
        Set<Integer> res = new HashSet<Integer>();
        if (node1==null||node2==null)return res;

        Set<Integer> set=new HashSet<Integer>();

        while (node1!=null){
            set.add(node1.val);
            node1=node1.next;
        }

        while (node2!=null){
            if (set.contains(node2.val))res.add(node2.val);
            node2=node2.next;
        }
        return res;

    }

    public Node q8_2(Node node1,Node node2){
        if (node1==null||node2==null)return null;
        int i=0;
        while (node1!=null&&node2!=null){
            if (node1==node2)return node1;
            if (i%2==0){
                node1=node1.next;
            }else{
                node2=node2.next;
            }
            i++;
        }

        return null;
    }
    @Test
    public void test8(){
        Node node1=new Node(1);
        node1.next=new Node(2);
        node1.next.next=new Node(3);
        node1.next.next.next=new Node(4);
        node1.next.next.next.next=new Node(5);



        Node node2=new Node(1);
        node2.next=new Node(2);
        node2.next.next=new Node(3);
        node2.next.next.next=new Node(3);
        node2.next.next.next=new Node(4);
        node2.next.next.next.next=new Node(5);

        Node node=new Node(6);
        node1.next.next.next.next.next=node;
        node2.next.next.next.next.next=node;


        Node rs = q8_2(node1, node2);
        MyUtil.printNode(rs);


    }

    /**
     * 将一个带头结点的单链表A分解为两个带头结点的单链表A和B，A表中含有原表中序号为奇数的元素，B中含有序号为偶数的元素
        不返回了，直接输出
     */
    public void q10(Node dummy){

        Node nodeADummy=new Node();
        Node nodeBDummy=new Node();

        Node aLast=nodeADummy;
        Node bLast=nodeBDummy;

        Node work=dummy.next;
        int i=1;
        while (work!=null){
            Node rest=work.next;

            if (i%2!=0){//奇
                aLast.next=work;
                aLast=aLast.next;
            }else{
                bLast.next=work;
                bLast=bLast.next;
            }
            work.next=null;


            work=rest;

            i++;
        }
        MyUtil.printNode(nodeADummy.next);
        MyUtil.printNode(nodeBDummy.next);
    }

    @Test
    public void test10(){
        Node node1=new Node(1);
        node1.next=new Node(2);
        node1.next.next=new Node(3);
        node1.next.next.next=new Node(4);
        node1.next.next.next.next=new Node(5);

        Node dummy=new Node();
        dummy.next=node1;
        q10(dummy);
    }



    public void q11(Node dummy){

        Node nodeADummy=new Node();
        Node nodeBDummy=new Node();

        Node aLast=nodeADummy;

        Node work=dummy.next;
        int i=1;
        while (work!=null){
            Node rest=work.next;

            if (i%2!=0){//奇
                aLast.next=work;
                aLast=aLast.next;
                work.next=null;
            }else{
                work.next=nodeBDummy.next;
                nodeBDummy.next=work;

            }


            work=rest;

            i++;
        }
        MyUtil.printNode(nodeADummy.next);
        MyUtil.printNode(nodeBDummy.next);
    }

    @Test
    public void test11(){
        Node node1=new Node(1);
        node1.next=new Node(2);
        node1.next.next=new Node(3);
        node1.next.next.next=new Node(4);
        node1.next.next.next.next=new Node(5);

        Node dummy=new Node();
        dummy.next=node1;
        q11(dummy);
    }

    public void q12(Node node){

        while (node!=null&&node.next!=null){

            if (node.val==node.next.val){
                node.next=node.next.next;
            }else{
                node=node.next;
            }
        }
    }

    @Test
    public void test12(){
        Node node1=new Node(2);
        node1.next=new Node(2);
        node1.next.next=new Node(2);
        node1.next.next.next=new Node(2);
        node1.next.next.next.next=new Node(2);


        q12(node1);
        MyUtil.printNode(node1);
    }

    public Node q13(Node node1,Node node2){
        Node dummy=new Node();

        while (node1!=null&&node2!=null){

            if (node1.val<node2.val){
                Node rest=node1.next;

                //node1头插
                node1.next=dummy.next;
                dummy.next=node1;


                node1=rest;
            }else{
                Node rest=node2.next;

                //node2头插
                node2.next=dummy.next;
                dummy.next=node2;


                node2=rest;
            }
        }
        if (node1==null){
            while (node2!=null){
                Node rest=node2.next;

                //node2头插
                node2.next=dummy.next;
                dummy.next=node2;

                node2=rest;
            }
        }else if (node2==null){
            Node rest=node1.next;

            //node1头插
            node1.next=dummy.next;
            dummy.next=node1;


            node1=rest;
        }
        return dummy.next;
    }

    @Test
    public void test13(){

        Node node1 = MyUtil.createNode(new int[]{1, 2, 3, 4, 5});
        Node node2 = MyUtil.createNode(new int[]{1, 2, 3, 4, 5});


        Node node = q13(node1.next, node2.next);
        MyUtil.printNode(node);


    }

}

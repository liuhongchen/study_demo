package 练习.链表;

import demo.d03_LinkedList.ListNode;

import java.util.*;

@SuppressWarnings("unchecked")
public class _23_合并K个有序链表 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode[] lists = {listNode, listNode,listNode};
        ListNode listNode1 = mergeKLists2(lists);
        System.out.println(listNode1);
    }


    /**
     * 方法一：最笨的办法，感觉时间复杂度和空间复杂度都很高
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        ArrayList<Integer> arrayList = new ArrayList();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                arrayList.add(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        Collections.sort(arrayList);
        for (Integer i : arrayList) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        return result.next;
    }


    /**
     * 方法二：分治思想
     * @param lists
     * @return
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null||lists.length==0)return null;
        ArrayList<ListNode> list= new ArrayList<ListNode>();
        Collections.addAll(list, lists);


        while (list.size()>=2){
            ArrayList<ListNode> temp=list;
            list=new ArrayList<ListNode>();
            for (int i=0;i<temp.size();i+=2){
                ListNode listNode = mergeTwoLists(temp.get(i), (i+1<temp.size()?temp.get(i+1):null));
                list.add(listNode);
            }

        }
        System.out.println(list);
        return list.get(0);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

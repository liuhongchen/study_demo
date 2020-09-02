package utils;


import model.TreeNode;
import 考研.线性表.链式表示.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MyUtil {

    public static void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }


    public static void printNode(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        System.out.println(sb.toString());
    }


    public static int[] createArr() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    public static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }


    public static Node createNode(int[] arr) {

        Node dummy = new Node();
        Node work = dummy;
        for (int value : arr) {
            work.next = new Node(value);
            work = work.next;
        }
        return dummy;

    }

    public static TreeNode createTree(int i) {
        TreeNode root = new TreeNode(1);
        i--;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        int val = 1;

        queue.offer(root);
        while (i > 0) {

            TreeNode treeNode = queue.poll();
            treeNode.left = new TreeNode(++val);
            queue.offer(treeNode.left);
            i--;
            if (i > 0) {
                treeNode.right = new TreeNode(++val);
                queue.offer(treeNode.right);
                i--;
            }
        }
        return root;
    }

    private static TreeNode createTreeByArr(Integer[] arr,int index){
        if (arr[index]==null)return null;
        TreeNode node=new TreeNode(arr[index]);
        if (2*index+2<arr.length){
            node.left=createTreeByArr(arr,2*index+1);
            node.right=createTreeByArr(arr,2*index+2);
        }
        return node;
    }
    public static void printTree(TreeNode tree) {

    }

    /**
     * 递归算法
     * @param arr 先序序列
     * @param brr 中序
     */
    public static TreeNode createTreeByPreIn(int[] arr,int[] brr){
        int rootVal=arr[0];
        int index=-1;
        TreeNode root=new TreeNode(rootVal);

        for (int i = 0; i < brr.length; i++) {//遍历中序序列寻找根节点值的索引
            if (brr[i]==rootVal){
                index=i;
                break;
            }
        }

        if (index==-1)return null;//中序中未找到根节点对应值


        //index=5
        if (index<=0){
            root.left=null;
        }else {
            int[] lPre = new int[index];
            System.arraycopy(arr, 1, lPre, 0, index);
            int[] lIn = new int[index];
            System.arraycopy(brr, 0, lIn, 0, index);
            root.left = createTreeByPreIn(lPre, lIn);
        }
        //index=5
        int rLen=arr.length-1-index;
        if (rLen==0){
            root.right=null;
        }else {
            int[] rPre = new int[rLen];
            System.arraycopy(arr, index + 1, rPre, 0, rLen);
            int[] rIn = new int[index];
            //TODO:这里数组越界
            System.arraycopy(brr, index + 1, rIn, 0, rLen);
            root.right = createTreeByPreIn(rPre, rIn);
        }
        return root;


    }


}

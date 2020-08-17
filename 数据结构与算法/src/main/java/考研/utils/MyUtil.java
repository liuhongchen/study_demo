package 考研.utils;


import 练习.树.TreeNode;
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

    public static void printTree(TreeNode tree) {

    }



}

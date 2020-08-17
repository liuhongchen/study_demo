package 考研.tree;


import org.junit.Test;
import 练习.树.TreeNode;
import 考研.utils.MyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1_树的遍历 {


    /**
     * 前序遍历递归
     */
    public void pre1(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);

        if (root.left != null) pre1(root.left);
        if (root.right != null) pre1(root.right);

    }

    /**
     * 前序遍历栈
     */
    public List<Integer> pre2(TreeNode root) {
        List<Integer> res = new ArrayList();

        if(root==null)return res;
        Stack<TreeNode> stack = new Stack();

        stack.push(root);


        while (stack.size() > 0) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);

            if(treeNode.right!=null)stack.push(treeNode.right);
            if(treeNode.left!=null)stack.push(treeNode.left);

        }

        return res;

    }


    @Test
    public void test1() {
        TreeNode root = MyUtil.createTree(8);

        List<Integer> res=pre2(root);

        System.out.println(res);
    }





}
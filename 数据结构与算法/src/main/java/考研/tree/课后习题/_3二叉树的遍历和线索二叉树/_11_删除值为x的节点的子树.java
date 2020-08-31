package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _11_删除值为x的节点的子树 {


    /**
     * 递归
     */
    public void m1(TreeNode root,int x){
       if (root==null)return;
       if (root.val==x){
           root.left=null;
           root.right=null;
       }else{
           if (root.left!=null)m1(root.left,x);
           if (root.right!=null)m1(root.right,x);
       }
    }


    /**
     * 迭代1(先序）
     */
    public void m2(TreeNode root,int x){
        if (root==null)return;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;

        while (p!=null|| !stack.isEmpty()){

            while (p!=null){
                if (p.val==x){
                    p.left=null;
                    p.right=null;
                    p=null;
                }else{
                    stack.push(p);
                    p=p.left;
                }
            }

            TreeNode pop = stack.pop();
            p=pop.right;
        }
    }

    /**
     * 层序遍历
     */
    public void m3(TreeNode root,int x){
        if (root==null)return;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val==x){
                node.left=null;
                node.right=null;
            }else{
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
        }
    }
    @Test
    public void test(){
        TreeNode root = MyUtil.createTree(10);
        m3(root,2);

        System.out.println();
    }
}

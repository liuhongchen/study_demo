package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;
import 练习.树.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _11_正解 {

    public Boolean m1(TreeNode root, int x) {

        if (root == null) return false;

        if (root.val == x) return true;

        if (root.left != null) {
            Boolean res = m1(root.left, x);
            if (res) root.left = null;
        }
        if (root.right != null) {
            Boolean res = m1(root.right, x);
            if (res) root.right = null;
        }

        return false;

    }


    @Test
    public void test(){
        TreeNode root = MyUtil.createTree(10);
        m3(root,4);

        System.out.println();
    }


    /**
     * 层序遍历
     */
    public void m2(TreeNode root,int x){
       if (root==null)return;

        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!=null){
                if (node.left.val==x){
                    node.left=null;
                }else {
                    queue.offer(node.left);
                }
            }
            if (node.right!=null){
                if (node.right.val==x){
                    node.right=null;
                }else{
                    queue.offer(node.right);
                }
            }
        }
    }


    /**
     * 后序遍历
     */
    public void m3(TreeNode root,int x){
        if (root==null)return;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;

        while (p!=null|| !stack.isEmpty()){

            while (p!=null){
                if (p.left!=null&&p.left.val==x){
                    p.left=null;
                    stack.push(p);
                    p=null;
                }else{
                    stack.push(p);
                    p=p.left;
                }
            }

            TreeNode pop = stack.pop();
            if (pop.right!=null&&pop.right.val==x)pop.right=null;
            p=pop.right;
        }
    }
}

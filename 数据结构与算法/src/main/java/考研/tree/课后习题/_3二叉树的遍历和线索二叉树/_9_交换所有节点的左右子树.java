package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.LinkedList;
import java.util.Queue;

public class _9_交换所有节点的左右子树 {

    /**
     * 递归方式
     */
    public void m1(TreeNode root){
        if (root==null)return;

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;

        if (root.left!=null)m1(root.left);
        if (root.right!=null)m1(root.right);
    }


    /**
     * 迭代方式
     */
    public void m2(TreeNode root){
        if (root==null)return;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;

            if (node.left!=null)queue.offer(node.left);
            if (node.right!=null)queue.offer(node.right);
        }
    }


    @Test
    public void test(){
        TreeNode tree = MyUtil.createTree(10);
        m2(tree);
        System.out.println();
    }
}

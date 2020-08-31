package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.LinkedList;
import java.util.Queue;

public class _8_统计双分支节点个数 {

    /**
     * 递归方式
     */
    public Integer m1(TreeNode root){
        if (root==null)return 0;
        int res=0;
        if (root.left!=null&&root.right!=null)res++;

        if (root.left!=null)res+=m1(root.left);
        if (root.right!=null)res+=m1(root.right);

        return res;
    }

    @Test
    public void test(){
        TreeNode root = MyUtil.createTree(10);
        System.out.println(m2(root));
    }

    /**
     * 遍历方式
     */
    public Integer m2(TreeNode root){
        if (root==null)return 0;

        int res=0;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!=null&&node.right!=null)res++;

            if (node.left!=null)queue.offer(node.left);
            if (node.right!=null)queue.offer(node.right);
        }

        return res;
    }
}

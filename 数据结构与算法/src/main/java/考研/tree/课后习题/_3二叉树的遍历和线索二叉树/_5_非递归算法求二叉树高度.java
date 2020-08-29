package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;
import 练习.树.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _5_非递归算法求二叉树高度 {


    public Integer m(TreeNode root){
        if (root==null)return 0;
        Deque<TreeNode> queue=new LinkedList<>();

        Integer level=0;
        queue.offer(root);
        TreeNode last=root;

        while (queue.size()>0){
            TreeNode pollNode = queue.poll();
            if (pollNode.left!=null)queue.offer(pollNode.left);
            if (pollNode.right!=null)queue.offer(pollNode.right);
            if (last==pollNode){
                level++;
                if (queue.size()>0)last=queue.getLast();
            }
        }
        return level;
    }

    @Test
    public void test(){
        TreeNode root = MyUtil.createTree(8);
        System.out.println(m(root));
    }

}

package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import 练习.树.TreeNode;

import java.util.*;

public class _4_二叉树从下往上从右往左遍历 {


    /**
     *也可以用stack来存储
     */
    public List<Integer> m(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if (root==null)return res;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);



        while (queue.size()>0){
            TreeNode node = queue.poll();
            if (node.left!=null)queue.offer(node.left);
            if (node.right!=null)queue.offer(node.right);

        }
        Collections.reverse(res);
        return res;
    }
}

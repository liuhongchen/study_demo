package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.LinkedList;
import java.util.Queue;

public class _19_带权路径长度 {


    public Integer res = 0;

    public Integer m1(TreeNode root) {

        if (root == null) return res;

        mm(root, 1);

        return res;
    }

    public void mm(TreeNode node, int depth) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res += (depth * node.val);
        }
        if (node.left!=null)mm(node.left,depth+1);
        if (node.right!=null)mm(node.right,depth+1);
    }

    @Test
    public void test() {
        TreeNode root = MyUtil.createTree(3);
//        m1(root);
//        System.out.println(res);
        System.out.println(m2(root));
    }


    public Integer m2(TreeNode root){
        if (root==null)return 0;

        int res=0;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);//本方法用null作为每一层的结束标识符

        int level=1;

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node==null){
                if (queue.size()>0)queue.offer(null);
                level++;
                continue;
            }
            if (node.left==null&&node.right==null){
                res+= node.val*level;
            }

            if (node.left!=null)queue.offer(node.left);
            if (node.right!=null)queue.offer(node.right);
        }

        return res;
    }
}

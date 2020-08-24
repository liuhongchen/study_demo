package 练习.树;

import model.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName:_104_二叉树的最大深度
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 09:18
 * @author:892698613@qq.com
 */
public class _104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = 0;
        if (root.left != null) leftDepth = maxDepth(root.left);
        int rightDepth = 0;
        if (root.right != null) rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    @Test
    public void test() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeUtil.createTreeNode(arr);
        maxDepth2(treeNode);
    }

    public int maxDepth2(TreeNode root) {
        if (root==null)return 0;

        int depth=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int size=queue.size();
        while (!queue.isEmpty()){
            depth++;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
            size=queue.size();
        }

        return depth;
    }


}

package 练习.树;

import model.TreeNode;
import org.junit.Test;

/**
 * ClassName:_814_二叉树剪枝
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 09:32
 * @author:892698613@qq.com
 */
public class _814_二叉树剪枝 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null) root.left = pruneTree(root.left);
        if (root.right != null) root.right = pruneTree(root.right);
        if (root.left == null && root.right == null) return root.val == 1 ? root : null;
        return root;

    }

    @Test
    public void test(){
        Integer[] arr={0,0,0};
        TreeNode treeNode = TreeUtil.createTreeNode(arr);
        TreeNode treeNode1 = pruneTree(treeNode);
        System.out.println(treeNode1);
    }

}

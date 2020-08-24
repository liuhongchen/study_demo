package 练习.树;

import model.TreeNode;

/**
 * ClassName:_222_完全二叉树的节点个数
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 21:07
 * @author:892698613@qq.com
 */
public class _222_完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {
        if (root==null)return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}

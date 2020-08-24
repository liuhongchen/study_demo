package 练习.树;

import model.TreeNode;

/**
 * ClassName:_965_单值二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 20:10
 * @author:892698613@qq.com
 */
public class _965_单值二叉树 {

    private int val;
    public boolean isUnivalTree(TreeNode root) {
        if (root==null)return true;
        val=root.val;
        return judge(root);
    }

    public boolean judge(TreeNode root){
        if (root.val!=val)return false;
        boolean left=true;
        boolean right=true;
        if (root.left!=null)left=judge(root.left);
        if (root.right!=null)right=judge(root.right);
        return left&&right;
    }
}

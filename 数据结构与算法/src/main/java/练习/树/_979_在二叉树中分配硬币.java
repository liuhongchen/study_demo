package 练习.树;

import model.TreeNode;

/**
 * ClassName:_979_在二叉树中分配硬币
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 09:47
 * @author:892698613@qq.com
 */
public class _979_在二叉树中分配硬币 {

    int count;

    public int dfs(TreeNode root){
        if (root==null)return 0;

        int left=dfs(root.left);
        int right=dfs(root.right);

        count+=(Math.abs(left)+Math.abs(right));

        return root.val+left+right-1;
    }
    public int distributeCoins(TreeNode root) {
        count=0;
        dfs(root);
        return count;
    }
}

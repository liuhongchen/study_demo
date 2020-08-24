package 练习.树;

import model.TreeNode;

/**
 * ClassName:_700_二叉树中的搜索
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-08 10:29
 * @author:892698613@qq.com
 */
public class _700_二叉树中的搜索 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null)return null;


        while (root!=null){
            if (root.val==val){
                return root;
            }else if (root.val>val){
                root=root.left;
            }else {
                root=root.right;
            }

        }
        return root;
    }

}

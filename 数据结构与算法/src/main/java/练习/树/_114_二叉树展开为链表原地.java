package 练习.树;

import model.TreeNode;

/**
 * ClassName:_114_二叉树展开为链表原地
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 18:28
 * @author:892698613@qq.com
 */
public class _114_二叉树展开为链表原地 {


    public void flatten(TreeNode root) {
        if (root==null)return;
        if (root.left!=null){
            if (root.right==null){
                root.right=root.left;
                root.left=null;
            }else{
                TreeNode temp=root.right;
                root.right=root.left;
                root.left=null;
                TreeNode t=root.right;
                while (t.right!=null)t=t.right;
                t.right=temp;
            }
        }
        flatten(root.right);

    }


}

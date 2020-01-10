package 练习.树;

import org.junit.Test;

import java.util.logging.Level;

/**
 * ClassName:_226_翻转二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 09:03
 * @author:892698613@qq.com
 */
public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root==null)return null;
        TreeNode temp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }


    @Test
    public void test(){

        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        TreeNode treeNode = invertTree(root);
        System.out.println(treeNode);
    }
}

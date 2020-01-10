package 练习.树;

import org.junit.Test;

/**
 * ClassName:_951_翻转等价二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 16:39
 * @author:892698613@qq.com
 */
public class _951_翻转等价二叉树 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2) return true;//这是都为null
        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        if (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))return true;

        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);


    }

    @Test
    public void test(){
        TreeNode r1=new TreeNode(1);
        r1.left=new TreeNode(2);
        r1.right=new TreeNode(3);
        r1.left.left=new TreeNode(4);
        r1.left.right=new TreeNode(5);
        r1.left.right.left=new TreeNode(7);
        r1.left.right.right=new TreeNode(8);
        r1.right.left=new TreeNode(6);


        TreeNode r2=new TreeNode(1);
        r2.right=new TreeNode(2);
        r2.left=new TreeNode(3);
        r2.right.left=new TreeNode(4);
        r2.right.right=new TreeNode(5);
        r2.right.right.left=new TreeNode(8);
        r2.right.right.right=new TreeNode(7);
        r2.left.right=new TreeNode(6);

        System.out.println(flipEquiv(r1, r2));
    }

}

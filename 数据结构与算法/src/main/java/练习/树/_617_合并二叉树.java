package 练习.树;

import model.TreeNode;

/**
 * ClassName:_617_合并二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 08:14
 * @author:892698613@qq.com
 */
public class _617_合并二叉树 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        //接下来的t1和t2都是非空的了
        TreeNode treeNode=new TreeNode(t1.val+t2.val);
        treeNode.left=mergeTrees(t1.left,t2.left);
        treeNode.right=mergeTrees(t1.right,t2.right);

        return treeNode;
    }
}

package 练习.树;

/**
 * ClassName:TreeNode
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-03 11:17
 * @author:892698613@qq.com
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public boolean isLeaf(){
        return left==null&&right==null;
    }

    public boolean hasTwoChildren(){
        return left!=null&&right!=null;
    }
}

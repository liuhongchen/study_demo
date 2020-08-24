package 练习.树;

import model.TreeNode;

/**
 * ClassName:_513_找树左下角的值
 * Package:练习.树
 * Description:https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 *
 * @date:2020-01-05 18:16
 * @author:892698613@qq.com
 */
public class _513_找树左下角的值 {

    private int max=-1;
    private int ans=-1;

    /**
     * 其实就是找最后一层的最左边的结点
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root==null)return -1;
        find(root,0);
        return ans;

    }

    public void find(TreeNode root,int h){
        h++;
        if (h>max){
            max=h;
            ans=root.val;
        }
        if (root.left!=null)find(root.left,h);
        if (root.right!=null)find(root.right,h);
    }
}

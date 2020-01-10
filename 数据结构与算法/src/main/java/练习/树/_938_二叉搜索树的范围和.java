package 练习.树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:_938_二叉搜索树的范围和
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 20:55
 * @author:892698613@qq.com
 */
public class _938_二叉搜索树的范围和 {


    int ans;
    public int rangeSumBST2(TreeNode root, int L, int R) {
        int ans = 0;
        if (root == null) return ans;

        List< Integer > res = new ArrayList<>();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.val>=L&&curr.val<=R)ans+=curr.val;
            curr = curr.right;
        }

        return ans;
    }

    @Test
    public void test(){
        Integer[] arr={10,5,15,3,7,13,18,1,null,6};
        TreeNode treeNode = TreeUtil.createTreeNode(arr);
        rangeSumBST1(treeNode,7,15);
    }

    public int rangeSumBST1(TreeNode root, int l, int r) {
        ans = 0;
        if (root == null) return ans;
        count(root,l,r);
        return ans;
    }

    public void count(TreeNode root,int l,int r){
        if (root==null) return;
        if (root.val>=l&&root.val<=r)ans+=root.val;
        if (root.val>=l)count(root.left,l,r);
        if (root.val<=r)count(root.right,l,r);
    }
}

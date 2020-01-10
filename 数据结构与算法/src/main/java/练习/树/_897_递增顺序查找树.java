package 练习.树;

import org.junit.Test;

import java.util.*;

/**
 * ClassName:_897_递增顺序查找树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 21:15
 * @author:892698613@qq.com
 */
public class _897_递增顺序查找树 {
    public TreeNode increasingBST(TreeNode root) {
        if (root==null)return null;

        TreeNode dummy=new TreeNode(0);
        TreeNode ans=dummy;

        Stack<TreeNode> stack=new Stack<>();

        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }

            root=stack.pop();
            dummy.right=new TreeNode(root.val);
            dummy=dummy.right;
            root=root.right;
        }

        return ans.right;

    }

    @Test
    public void test(){
        TreeNode root=new TreeNode(379);
        root.left=new TreeNode(826);
        increasingBST(root);
    }
}

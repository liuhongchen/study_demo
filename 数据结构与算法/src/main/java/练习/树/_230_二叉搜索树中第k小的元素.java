package 练习.树;

import java.util.Stack;

/**
 * ClassName:_230_二叉搜索树中第k小的元素
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 09:45
 * @author:892698613@qq.com
 */
public class _230_二叉搜索树中第k小的元素 {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack=new Stack<>();

        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }

            root=stack.pop();
            k--;
            if (k==0)return root.val;
            root=root.right;
        }

        return -1;

    }
}

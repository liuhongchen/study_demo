package 练习.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:_145_二叉树的后序遍历
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-04 21:53
 * @author:892698613@qq.com
 */
public class _145_二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        if (root == null) return arr;
        if (root.left != null) {
            arr.addAll(postorderTraversal(root.left));
        }
        if (root.right != null) {
            arr.addAll(postorderTraversal(root.right));
        }
        arr.add(root.val);
        return arr;
    }


    public List<Integer> postorder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode pop = stack.pop();
            if (pop.right == null) {
                res.add(pop.val);
            } else {
                stack.push(new TreeNode(pop.val));
            }

            curr = pop.right;
        }
        return res;
    }
}

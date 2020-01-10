package 练习.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName:_144_二叉树的前序遍历
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 10:23
 * @author:892698613@qq.com
 */
public class _144_二叉树的前序遍历 {


    /**
     * 做法1,递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> arr = new ArrayList<>();
        if (root == null) return arr;

        arr.add(root.val);
        arr.addAll(preorderTraversal1(root.left));
        arr.addAll(preorderTraversal1(root.right));
        return arr;

    }


    /**
     * 做法2,遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        List<Integer> res = new ArrayList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }
        return res;
    }


}

package 练习.树;

import org.junit.Test;

import java.util.Stack;

/**
 * ClassName:_669_修剪BST
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-08 11:47
 * @author:892698613@qq.com
 */
public class _669_修剪BST_________ {


    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode res = root;

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                if (root.val < L) {
                    stack.peek().left = root.right;
                    root = root.right;
                }else {
                    stack.push(root);
                    root = root.left;
                }
            }

            root = stack.pop();
            if (root.val > R) {
                root.right = null;
            }
            root = root.right;

        }
        return res;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        trimBST(root, 1, 2);
    }

}

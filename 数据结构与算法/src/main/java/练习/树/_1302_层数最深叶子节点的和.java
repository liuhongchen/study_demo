package 练习.树;

import model.TreeNode;

/**
 * ClassName:_1302_层数最深叶子节点的和
 * Package:练习.树
 * Description:https://leetcode-cn.com/problems/deepest-leaves-sum/
 *
 * @date:2020-01-03 11:17
 * @author:892698613@qq.com
 */
public class _1302_层数最深叶子节点的和 {


    public static int result = 0;
    public static int depth = 0;

    public static int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int count = 0;
        depth = getDept(root);
        count(root, 1);
        return result;
    }

    public static int getDept(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left != null) left = getDept(root.left);
        if (root.right != null) right = getDept(root.right);
        return Math.max(left, right) + 1;
    }


    public static void count(TreeNode root, int cell) {
        if (cell == depth) {
            result += root.val;
            return;
        }
        if (root.left != null) count(root.left, cell + 1);
        if (root.right != null) count(root.right, cell + 1);
    }

    public static void main(String[] args) {
        Integer[] arr={6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        TreeNode root = TreeUtil.createTreeNode(arr);
        deepestLeavesSum(root);
        System.out.println(result);
    }

}

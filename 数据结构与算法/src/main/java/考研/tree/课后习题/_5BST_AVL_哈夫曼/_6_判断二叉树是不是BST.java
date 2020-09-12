package 考研.tree.课后习题._5BST_AVL_哈夫曼;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.Stack;

public class _6_判断二叉树是不是BST {


    /**
     * 递归
     */
    //错误 10 5 15 null null 6 20
    public Boolean m1(TreeNode root){
        if (root==null)return true;

        if (root.left==null&&root.right==null)return true;
        if (root.left!=null&&root.right==null){
            if (root.left.val>=root.val)return false;
            return m1(root.left);

        }else if (root.left==null&&root.right!=null){
            if (root.val>=root.right.val)return false;
            return m1(root.right);
        }else{
            if (root.left.val>=root.val||root.val>=root.right.val)return false;
            return m1(root.left)&&m1(root.right);
        }
    }


    @Test
    public void test() {
        TreeNode tree = MyUtil.buildTree(
                new int[]{7, 2, 1, 4, 3, 6, 8},
                new int[]{1, 2, 3, 4, 6, 7, 8});
//        TreeNode tree = MyUtil.createTree(10);

        System.out.println(isValidBST(tree));
    }


    /**
     * 遍历
     */
    public Boolean isValidBST(TreeNode root){
        if (root==null)return true;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;

        long temp=Long.MIN_VALUE;

        while (p!=null|| !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            TreeNode pop = stack.pop();
//            if (pop.val<=temp&&!stack.isEmpty())return false;
            if (pop.val<=temp)return false;
            temp=pop.val;
            p=pop.right;
        }
        return true;
    }
}

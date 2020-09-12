package 考研.tree.经典;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.Stack;

public class _3_BST {


    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode p = root;

        while (true) {
            if (p.val == val) {
                return root;
            } else if (p.val > val) {
                if (p.left == null) {
                    p.left = new TreeNode(val);
                    return root;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new TreeNode(val);
                    return root;
                }
                p = p.right;

            }

        }
    }


    @Test
    public void test() {
        TreeNode tree = MyUtil.buildTree(
                new int[]{7, 2, 1, 4, 3, 6, 8},
                new int[]{1, 2, 3, 4, 6, 7, 8});

        System.out.println(tree);
        System.out.println();

        TreeNode insert = insert(tree, 5);
        System.out.println();

    }


    public TreeNode delete(TreeNode root, int val) {
        if (root == null) return null;

        return null;
    }

    public TreeNode dd(TreeNode node, int val) {
        if (node == null) return null;
        return null;
    }


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)return null;

        TreeNode pre=null;
        int direction=-1;//0左1右
        TreeNode p=root;
        while (true){
            if (p.val==key){
                if (pre==null)return null;
                if (p.left==null&&p.right==null){
                    if (direction==0){
                        pre.left=null;
                        return root;
                    }else{
                        pre.right=null;
                        return root;
                    }
                }else if (p.left!=null&&p.right==null||(p.left==null&&p.right!=null)){
                    if (direction==0){
                        pre.left=(p.left!=null)?p.left:p.right;
                        return root;
                    }else{
                        pre.right=(p.left!=null)?p.left:p.right;
                        return root;
                    }
                }else {
                    successor(root);
                }
            }
        }
    }

    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

}

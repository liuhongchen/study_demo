package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.Queue;
import java.util.Stack;

public class _12_打印值为x的节点的所有祖先 {

    /**
     * 递归
     */
    public Boolean m1(TreeNode root, int x) {
        if (root == null) return false;

        if (root.val==x)return true;

        if (root.left != null) {
            if (m1(root.left, x)) {
                System.out.println(root.val);
                return true;
            }
        }
        if (root.right != null) {
            if (m1(root.right, x)) {
                System.out.println(root.val);
                return true;
            }
        }

        return false;


    }


    /**
     * 后序遍历
     */
    public void m2(TreeNode root,int x){
        if (root==null)return;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;

        while (p!=null|| !stack.isEmpty()){

            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            TreeNode pop = stack.pop();

            if (pop.val==x)break;

            if (pop.right!=null){
                p=pop.right;
                pop.right=null;
                stack.push(pop);
            }

        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().val);
        }
    }


    @Test
    public void test(){
        TreeNode tree = MyUtil.createTree(10);
        m2(tree,10);
    }
}

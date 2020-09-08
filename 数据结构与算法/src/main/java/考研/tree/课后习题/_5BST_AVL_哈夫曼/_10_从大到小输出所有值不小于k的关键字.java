package 考研.tree.课后习题._5BST_AVL_哈夫曼;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.Stack;

public class _10_从大到小输出所有值不小于k的关键字 {


    public void m1(TreeNode root,int k){
        if (root==null)return;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;

        while (p!=null|| !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.right;
            }

            TreeNode pop = stack.pop();
            if (pop.val>=k) System.out.println(pop.val);
            if (pop.val<k)return;
            p=pop.left;
        }
    }


    @Test
    public void test() {
        TreeNode tree = MyUtil.buildTree(
                new int[]{7, 2, 1, 4, 3, 6, 8},
                new int[]{1, 2, 3, 4, 6, 7, 8});

        m1(tree,3);
    }
}

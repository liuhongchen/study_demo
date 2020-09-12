package 考研.tree.课后习题._5BST_AVL_哈夫曼;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.Arrays;
import java.util.Stack;

public class _9_BST最小和最大关键字 {

    public int[] findMinAndMax(TreeNode root){
        if (root==null)return null;

        int min=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        boolean flag=false;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while (p!=null||!stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            TreeNode pop = stack.pop();
            if (!flag){
                min= pop.val;
                flag=true;
            }
            max=pop.val;
            p=pop.right;

        }

        return new int[]{min,max};

    }


    @Test
    public void test() {
        TreeNode tree = MyUtil.buildTree(
                new int[]{7, 2, 1, 4, 3, 6, 8},
                new int[]{1, 2, 3, 4, 6, 7, 8});

        System.out.println(Arrays.toString(findMinAndMax(tree)));
    }
}

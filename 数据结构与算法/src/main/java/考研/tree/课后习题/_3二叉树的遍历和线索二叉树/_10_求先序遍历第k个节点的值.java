package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _10_求先序遍历第k个节点的值 {


    public Integer m1(TreeNode root,int k){
        if (root==null||k<0)return null;
        int count=0;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;

        while (p!=null|| !stack.isEmpty()){
            while (p!=null){
                count++;
                if (count==k)return p.val;
                stack.push(p);
                p=p.left;
            }
            TreeNode pop = stack.pop();
            p=pop.right;
        }
        return null;

    }

    @Test
    public void test(){
        TreeNode root = MyUtil.createTree(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(m1(root, i+1));
        }
    }
}

package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;


import 练习.树.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _3_后序遍历二叉树的非递归算法 {


    public List<Integer> postorder(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if (root==null)return res;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;

        while (p!=null||stack.size()>0){

            while (p!=null){
                stack.push(p);
                p=p.left;
            }

            TreeNode pop = stack.pop();
            if (pop.right==null){
                res.add(pop.val);
            }else{
                stack.push(new TreeNode(pop.val));
            }
            p=pop.right;
        }
        return res;
    }

}

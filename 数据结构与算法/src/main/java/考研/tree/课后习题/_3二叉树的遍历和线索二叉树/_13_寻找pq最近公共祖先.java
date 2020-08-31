package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.Stack;

public class _13_寻找pq最近公共祖先 {


    /**
     * 暴力递归做法
     */
    public TreeNode m1(TreeNode root,TreeNode p,TreeNode q){
        if (root==null)return null;
        //TODO：如果p==null或q==null的处理，应该是返回该节点的父节点吧
        if (p==null||q==null)return null;//暂时先认为他们违法

        Stack<TreeNode> route1=new Stack<>();
        Stack<TreeNode> route2=new Stack<>();

        Boolean mm1 = mm(root, p, route1);
        Boolean mm2 = mm(root, q, route2);

        if (!mm1||!mm2)return null;

        TreeNode res=null;
        while (!route1.isEmpty() && !route2.isEmpty()){
            TreeNode pop1 = route1.pop();
            TreeNode pop2 = route2.pop();
            if (pop1==pop2){
                res=pop1;
            }else{
                return res;
            }

        }

        return res;
    }


    public Boolean mm(TreeNode root, TreeNode target, Stack<TreeNode> stack){
        if (root==null)return false;
        if (root==target){
            stack.add(root);
            return true;
        }
        if (root.left!=null&&mm(root.left,target,stack)){
            stack.push(root);
            return true;
        }
        if (root.right!=null&&mm(root.right,target,stack)){
            stack.push(root);
            return true;
        }
        return false;
    }


    @Test
    public void test(){

        TreeNode tree = MyUtil.createTree(10);

        TreeNode treeNode = m1(tree, tree.right.left, tree.left.right.left);
        System.out.println(treeNode);
    }
}

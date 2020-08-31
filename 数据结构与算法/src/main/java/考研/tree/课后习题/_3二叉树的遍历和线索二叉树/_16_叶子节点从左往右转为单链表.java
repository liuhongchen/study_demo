package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.Stack;

public class _16_叶子节点从左往右转为单链表 {



    public TreeNode m1(TreeNode root){
        if (root==null)return null;

        TreeNode lastLeaf=null;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;

        while (p!=null|| !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            TreeNode pop = stack.pop();
            if (pop.left==null&&pop.right==null){
                if (lastLeaf!=null) lastLeaf.right=pop;
                lastLeaf=pop;
            }
            p=pop.right;
        }
        return root;
    }


    @Test
    public void test() {
        TreeNode tree = MyUtil.createTree(3);
        tree.left.left=new TreeNode(4);
        tree.right.left=new TreeNode(5);
        tree.right.left.left=new TreeNode(6);

        TreeNode treeNode = m1(tree);
        System.out.println(treeNode);

    }
}

package 考研.tree.课后习题._4树和森林;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

public class _6_孩子兄弟链表表示的树的深度 {


    public Integer maxDepth=0;

    public Integer m1(TreeNode root){

        if (root==null)return maxDepth;

        maxDepth=1;
//        if (root.left==null)return maxDepth;

        return m11(root);
    }

    public Integer m11(TreeNode root){
        if (root==null)return 0;
        int res=0;
        int leftDepth=0;
        int rightDepth=0;
        if (root.left!=null){
            leftDepth=m11(root.left);
            leftDepth++;
        }
        if (root.right!=null){
            rightDepth+=m11(root.right);
        }
        return Math.max(leftDepth,rightDepth);

    }

    @Test
    public void test() {
        TreeNode g=new TreeNode(7);
        TreeNode f=new TreeNode(6);
        TreeNode e=new TreeNode(5);
        e.right=f;
        TreeNode d=new TreeNode(4);
        d.left=e;
        d.right=g;
        TreeNode c=new TreeNode(3);
        TreeNode b=new TreeNode(2);
        b.left=c;
        b.right=d;
        TreeNode a=new TreeNode(1);
        a.left=b;

        System.out.println(m1(a));
    }
}

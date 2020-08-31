package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

public class _17_二叉树相似 {
    
    
    public Boolean m1(TreeNode t1,TreeNode t2){
        if (t1==t2)return true;//包含两棵树指向同一个地址或两棵树都为null的情况

        if (t1==null||t2==null)return false;//与上面结合，这里是其中一个为null时返回false


        return m1(t1.left, t2.left) && m1(t1.right, t2.right);


    }


    @Test
    public void test() {
        TreeNode tree1 = MyUtil.createTree(10);
        TreeNode tree2 = MyUtil.createTree(11);
        System.out.println(m1(tree1,tree2));
    }
}

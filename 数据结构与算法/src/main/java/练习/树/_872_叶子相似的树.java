package 练习.树;

import model.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * ClassName:_872_叶子相似的树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 11:07
 * @author:892698613@qq.com
 */
public class _872_叶子相似的树 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2==null)return true;
        if (root1==null||root2==null)return false;

        //现在root1和root2都不为null

        Queue<Integer> queue=new LinkedList<>();

        Stack<TreeNode> stack=new Stack<>();


        while (root1!=null||!stack.isEmpty()){
            while (root1!=null){
                stack.push(root1);
                root1=root1.left;
            }
            root1=stack.pop();
            if (root1.left==null&&root1.right==null)queue.offer(root1.val);
            root1=root1.right;
        }
        System.out.println("he");
        while (root2!=null||!stack.isEmpty()){
            while (root2!=null){
                stack.push(root2);
                root2=root2.left;
            }
            root2=stack.pop();
            if (root2.left==null&&root2.right==null){
                if(queue.size()==0||queue.poll()!=root2.val)return false;
            }
            root2=root2.right;
        }
        return true;
    }

    @Test
    public void test(){
        Integer[] a1={3,5,1,6,2,9,8,null,null,7,4};
        TreeNode root1=TreeUtil.createTreeNode(a1);
        Integer[] a2={3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        TreeNode root2=TreeUtil.createTreeNode(a2);
        leafSimilar(root1,root2);
    }

}

package 练习.树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:_94_二叉树的中序遍历
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-04 21:33
 * @author:892698613@qq.com
 */
public class _94_二叉树的中序遍历 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        if (root==null)return arr;
        if (root.left!=null){
            arr.addAll(inorderTraversal(root.left));
        }
        arr.add(root.val);
        if (root.right!=null){
            arr.addAll(inorderTraversal(root.right));
        }
        return arr;
    }

    @Test
    public void test(){
        Integer[] arr={1,null,2,3};
        TreeNode treeNode = TreeUtil.createTreeNode(arr);
        List<Integer> integers = inorderTraversal(treeNode);
        System.out.println(integers);
    }
}

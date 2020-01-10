package 练习.树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * ClassName:_199_二叉树的右视图
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 10:33
 * @author:892698613@qq.com
 */
public class _199_二叉树的右视图 {

    private List<Integer> ans;

    public List<Integer> rightSideView(TreeNode root) {
        ans=new ArrayList<>();
        if (root==null)return ans;
        dodo(root,0);
        return ans;
    }


    public void dodo(TreeNode root,int depth){
        depth++;

        if (ans.size()<depth){
            ans.add(root.val);
        }else{
            ans.set(depth-1,root.val);
        }
        if (root.left!=null)dodo(root.left,depth);
        if (root.right!=null)dodo(root.right,depth);
    }


    @Test
    public void test(){
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(3);
        rightSideView(root);
    }


    @Test
    public void test1(){
        List<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(0,3);
        System.out.println(arr);
    }

}

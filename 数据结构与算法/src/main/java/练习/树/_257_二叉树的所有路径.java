package 练习.树;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_257_二叉树的所有路径
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 11:56
 * @author:892698613@qq.com
 */
public class _257_二叉树的所有路径 {

    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans=new ArrayList<>();
        if (root==null)return ans;

        dodo(root,null);
        return ans;


    }

    public void dodo(TreeNode root,String prev){
        prev=(prev==null)?String.valueOf(root.val):prev+"->"+root.val;

        if (root.left==null&&root.right==null){
            ans.add(prev);
        }else{
            if (root.left!=null)dodo(root.left,prev);
            if (root.right!=null)dodo(root.right,prev);
        }
    }
}

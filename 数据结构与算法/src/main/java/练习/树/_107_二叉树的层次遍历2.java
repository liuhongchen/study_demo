package 练习.树;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:_107_二叉树的层次遍历2
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 10:05
 * @author:892698613@qq.com
 */
public class _107_二叉树的层次遍历2 {


    private List<List<Integer>> ans;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ans=new ArrayList<>();
        if (root==null)return ans;
        dodo(root,0);
        Collections.reverse(ans);
        return ans;
    }


    public void dodo(TreeNode root,int depth){
        depth++;
        if (ans.size()<depth)ans.add(new ArrayList<>());
        List<Integer> list = ans.get(depth - 1);
        list.add(root.val);
        if (root.left!=null)dodo(root.left,depth);
        if (root.right!=null)dodo(root.right,depth);
    }
}

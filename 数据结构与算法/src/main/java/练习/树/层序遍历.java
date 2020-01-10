package 练习.树;

import java.util.*;

/**
 * ClassName:层序遍历
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 17:39
 * @author:892698613@qq.com
 */
public class 层序遍历 {


    public List<Integer> levelOrderTraversal(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (queue.size()>0){
            TreeNode treeNode = queue.poll();
            ans.add(treeNode.val);
            if (treeNode.left!=null)queue.offer(treeNode.left);
            if (treeNode.right!=null)queue.offer(treeNode.right);
        }
        return ans;
    }
}

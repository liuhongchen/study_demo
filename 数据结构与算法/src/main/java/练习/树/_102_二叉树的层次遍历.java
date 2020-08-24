package 练习.树;

import model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:_102_二叉树的层次遍历
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-17 20:34
 * @author:892698613@qq.com
 */
public class _102_二叉树的层次遍历 {


    private List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(TreeNode root) {
        ans=new ArrayList<>();
        if (root==null)return ans;

        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);
        int size=1;
        int count=0;
        List<Integer> level=new ArrayList<>();

        while (!queue.isEmpty()){
            if(size==0){
                ans.add(level);
                level=new ArrayList<>();
                size=count;
                count=0;
            }

            TreeNode node = queue.poll();
            size--;
            if (root.left!=null){
                queue.offer(root.left);
                count++;
            }

            if (root.right!=null){
                queue.offer(root.right);
                count++;
            }
        }

        return ans;

    }


    @Test
    public void test(){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        levelOrder(root);
    }
}

package 练习.树;

import model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_637_二叉树的层平均值
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 11:00
 * @author:892698613@qq.com
 */
public class _637_二叉树的层平均值 {



    private List<Long> ans;
    private List<Integer> counts;
    public List<Double> averageOfLevels(TreeNode root) {
        ans=new ArrayList<>();
        counts=new ArrayList<>();
        List<Double> res=new ArrayList<>();
        if (root==null)return res;
        dodo(root,0);
        int len=ans.size();
        for (int i=0;i<len;i++){
            double sum=(double)ans.get(i);
            int count=counts.get(i);
            res.add((sum/count));
        }
        return res;
    }


    public void dodo(TreeNode root,int depth){
        depth++;

        if(ans.size()<depth){
            ans.add((long) root.val);
            counts.add(1);
        }else{
            ans.set(depth-1,ans.get(depth-1)+root.val);
            counts.set(depth-1,counts.get(depth-1)+1);
        }

        if (root.left!=null)dodo(root.left,depth);
        if (root.right!=null)dodo(root.right,depth);
    }

    @Test
    public void  test(){
        TreeNode root=new TreeNode(2147483647);
        root.left=new TreeNode(2147483647);
        root.right=new TreeNode(2147483647);
        averageOfLevels(root);
    }

}

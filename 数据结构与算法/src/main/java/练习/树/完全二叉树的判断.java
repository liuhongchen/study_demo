package 练习.树;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:完全二叉树的判断
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 18:25
 * @author:892698613@qq.com
 */
public class 完全二叉树的判断 {


    public boolean judgeFBT(TreeNode root){
        if(root==null)return false;

        List<Integer> arr=new ArrayList<>();

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            arr.add(size);
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        int index=0;
        int size=arr.size();
        for (int i=1;i<size;i++){
            if (arr.get(i-1)*2==arr.get(i))continue;
            index=i;
            break;
        }
        return index==arr.size()-1;
    }
}

package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.LinkedList;
import java.util.Queue;

public class _14_二叉树宽度 {


    public Integer m1(TreeNode root){
        if (root==null)return 0;
        int res=-1;
        int count=0;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);


        //采用层序遍历，栈弹出null表示一层结束了
        // 此时这一层的所有子节点都在队列中了，再入队一个null，作为下一层的结束标识
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node==null){//
                if (queue.size()>0)queue.offer(null);
                res=Math.max(res,count);
                count=0;
                continue;
            }
            if (node.left!=null){
                queue.offer(node.left);
                count++;
            }
            if (node.right!=null){
                queue.offer(node.right);
                count++;
            }
        }
        return res;
    }


    @Test
    public void test(){
        TreeNode root= MyUtil.createTree(10);
        System.out.println(m1(root));
    }
}

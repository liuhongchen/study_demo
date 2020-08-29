package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _7_完全二叉树判断 {

    //不太对
    public Boolean m1(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int flag = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();

            if (flag == 0) {//未出现单左或叶子节点
                if (node.left == null && node.right == null) {//叶子节点
                    flag = 1;
                } else if (node.left == null ) {//单右
                    return false;
                }else{//单左
                    queue.offer(node.left);
                }
            } else if (flag == 1) {//出现了单左或叶子，剩下的所有节点都不能有孩子
                if (node.left != null||node.right!=null) return false;
            }
        }
        return true;
    }



    @Test
    public void test(){
        TreeNode root = MyUtil.createTree(8);
        System.out.println(m1(root));
    }


    //标准答案
    //把空的node 也存进去，如果遇到空node，看队列后面还有么有节点，如果还有节点就是false
    public Boolean m2(TreeNode root){
        if (root==null)return true;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node!=null){
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                while (!queue.isEmpty()){
                    TreeNode node2 = queue.poll();
                    if (node2!=null)return false;
                }
            }
        }
        return true;
    }
}

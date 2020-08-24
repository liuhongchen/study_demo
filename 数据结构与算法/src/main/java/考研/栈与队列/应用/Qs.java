package 考研.栈与队列.应用;

import org.junit.Test;
import model.TreeNode;
import utils.MyUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Qs {


    /**
     * 二叉树层序遍历
     */
    public String q0(TreeNode root){
        if (root==null)return null;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();

        StringBuilder sb=new StringBuilder();

        queue.offer(root);
        while (queue.size()>0){
            TreeNode treeNode = queue.poll();
            sb.append(treeNode.val+" ");
            if (treeNode.left!=null)queue.offer(treeNode.left);
            if (treeNode.right!=null)queue.offer(treeNode.right);
        }

        return sb.toString();

    }


    @Test
    public void test0(){
        TreeNode tree = MyUtil.createTree(10000000);
        String s = q0(tree);
        System.out.println(s);
    }

    /**
     * P96 q1
     */
    public Boolean q1(String str){
        char[] chars = str.toCharArray();

        Stack<Character> stack=new Stack<Character>();

        for (char c : chars) {
            if (stack.size()==0&&(c==']'||c==')'||c=='}')){
                return false;
            }else if (stack.size()==0){
                stack.push(c);
            }else{
                Character peek = stack.peek();
                switch (c){
                    case ']':
                        if (peek=='[')stack.pop();
                        break;
                    case ')':
                        if (peek=='(')stack.pop();
                        break;
                    case '}':
                        if (peek=='{')stack.pop();
                        break;
                    default:
                        stack.push(c);
                }
            }
        }
        return stack.size() == 0;
    }

    @Test
    public void test1(){
        String s="[[]](){}";

        System.out.println(q1(s));
    }

}

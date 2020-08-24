package 考研.树;

import org.junit.Test;
import model.TreeNode;
import 练习.树.TreeUtil;
import utils.MyUtil;

import java.util.*;

/**
 * ClassName:_1_树的遍历
 * Package:考研.树
 * Description:
 *
 * @date: 2020-08-17 15:10
 * @author:Hansing liuhongchengege123@gmail.com
 */

@SuppressWarnings("unchecked")
public class _1_树的遍历 {

    /**
     * NLR递归方式
     */
    public void pre1(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);

        if (root.left != null) pre1(root.left);
        if (root.right != null) pre1(root.right);

    }

    /**
     * NLR遍历方式
     */
    public List<Integer> pre3(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null || stack.size() > 0) {

            while (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }

        return res;

    }


    @Test
    public void testNLR() {
        TreeNode root = MyUtil.createTree(8);

        List<Integer> list = pre3(root);

        System.out.println(list);
    }


    /**
     * LNR递归方式遍历
     */

    public void lnr1(TreeNode root) {

        if (root == null) return;


        if (root.left != null) lnr1(root.left);
        System.out.println(root.val);
        if (root.right != null) lnr1(root.right);


    }


    public List<Integer> lnr3(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while (p != null || stack.size() > 0) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            p = node.right;

        }
        return res;
    }

    @Test
    public void testLNR() {
        TreeNode root = MyUtil.createTree(7);

        System.out.println(lnr3(root));
    }


    /**
     * 后序遍历递归
     */
    public void lrn1(TreeNode root) {
        if (root == null) return;

        if (root.left != null) lrn1(root.left);
        if (root.right != null) lrn1(root.right);

        System.out.println(root.val);
    }


    /**
     * 后序遍历递归
     */
    public List<Integer> lrn3(TreeNode root) {

        List<Integer> res=new ArrayList<>();

        if (root==null)return res;

        Stack<TreeNode> stack=new Stack<>();

        TreeNode p=root;


        while (p!=null||stack.size()>0){

            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            TreeNode node = stack.pop();
            if (node.right==null){
                res.add(node.val);
            }else{
                stack.push(new TreeNode(node.val));
            }
            p=node.right;
        }

        return res;

    }


    @Test
    public void testLRN() {
        TreeNode root = MyUtil.createTree(7);

        System.out.println(lrn3(root));
    }


    /**
     * 层序遍历
     */
    public List<Integer> levelOrder(TreeNode root){
        List<Integer> res=new ArrayList();

        Queue<TreeNode> queue=new LinkedList();


        queue.offer(root);

        while(queue.size()>0){
            TreeNode node=queue.poll();
            res.add(node.val);
            if(node.left!=null)queue.offer(node.left);
            if(node.right!=null)queue.offer(node.right);

        }

        return res;
    }


    @Test
    public void testLevel(){
//        TreeNode root = MyUtil.createTree(8);
        TreeNode root = TreeUtil
                .createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});

        List<Integer> list = levelOrder(root);
        System.out.println(list);
    }

}

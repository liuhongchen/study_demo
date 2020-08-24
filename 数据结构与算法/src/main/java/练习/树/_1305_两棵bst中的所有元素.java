package 练习.树;

import model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * ClassName:_1305_两棵bst中的所有元素
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-07 12:59
 * @author:892698613@qq.com
 */
public class _1305_两棵bst中的所有元素 {


    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        List<Integer> list = traversal(root1);
        list.addAll(traversal(root2));
        Collections.sort(list);
        return list;

    }

    public List<Integer> traversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.addAll(traversal(root.left));
        res.add(root.val);
        res.addAll(traversal(root.right));
        return res;
    }


    /**
     * 方法2
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> res=new ArrayList<>();
        if (root1==null&&root2==null)return res;

        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();

        TreeNode curr1=root1;
        TreeNode curr2=root2;



        while (curr1!=null||curr2!=null||!stack1.isEmpty()||!stack2.isEmpty()){
            while (curr1!=null){
                stack1.push(curr1);
                curr1=curr1.left;
            }
            while (curr2!=null){
                stack2.push(curr2);
                curr2=curr2.left;
            }

            if (stack1.size()>0)curr1=stack1.pop();
            if (stack2.size()>0)curr2=stack2.pop();

            if (curr1!=null&&curr2!=null) {
                if (curr1.val < curr2.val) {
                    res.add(curr1.val);
                    curr1 = curr1.right;
                } else {
                    res.add(curr2.val);
                    curr2 = curr2.right;
                }
            }else if (curr1!=null) {
                res.add(curr1.val);
                curr1 = curr1.right;
            }else if (curr2!=null) {
                res.add(curr2.val);
                curr2=curr2.right;
            }

        }
        return res;
    }

    public void add(List<Integer> res,int v1,int v2){
        if (v1<v2){
            res.add(v1);
            res.add(v2);
        }else{
            res.add(v2);
            res.add(v1);
        }
    }

    @Test
    public void test(){
        Integer[] a1={0,-10,10};
        TreeNode root1=TreeUtil.createTreeNode(a1);
        Integer[] a2={5,1,7,0,2};
        TreeNode root2=TreeUtil.createTreeNode(a2);

        getAllElements2(root1,root2);
    }

}

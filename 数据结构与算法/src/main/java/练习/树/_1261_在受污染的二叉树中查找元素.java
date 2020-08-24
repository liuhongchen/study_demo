package 练习.树;

import model.TreeNode;
import org.junit.Test;

/**
 * ClassName:_1261_在受污染的二叉树中查找元素
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 08:59
 * @author:892698613@qq.com
 */
public class _1261_在受污染的二叉树中查找元素 {

    class FindElements {

        TreeNode root;

        public FindElements(TreeNode root) {
            this.root=root;
            if (root==null)return;
            root.val=0;
            init(root.left,0,1);
            init(root.right,0,2);
            System.out.println("hello");
        }

        public void init(TreeNode root,int parentVal,int direct){
            if(root==null)return;
            root.val=parentVal*2+direct;
            init(root.left,root.val,1);
            init(root.right,root.val,2);

        }

        public boolean find(int target) {
            return find(root,target);
        }

        public boolean find(TreeNode root,int val){
            if(root==null)return false;
            if (root.val==val)return true;
            boolean left = find(root.left, val);
            boolean right = find(root.right, val);
            return left||right;
        }
    }

    @Test
    public void test(){
        TreeNode root=new TreeNode(-1);
        root.right=new TreeNode(-1);
        root.left=new TreeNode(-1);
        root.left.left=new TreeNode(-1);
        root.left.right=new TreeNode(-1);
        FindElements findElements=new FindElements(root);

        System.out.println(findElements.find(1));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(5));
    }

}

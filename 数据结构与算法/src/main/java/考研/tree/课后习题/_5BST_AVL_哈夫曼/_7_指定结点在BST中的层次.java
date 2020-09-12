package 考研.tree.课后习题._5BST_AVL_哈夫曼;

import model.TreeNode;

public class _7_指定结点在BST中的层次 {


    public Integer m1(TreeNode root,int val){
        if (root==null)return null;

        TreeNode p=root;
        int count=1;
        while (true){
            if (p==null)return null;
            if (p.val==val){
                return count;
            }else if (val>p.val){
                p=p.left;
                count++;
            }else{
                p=p.right;
                count++;
            }
        }

    }
}

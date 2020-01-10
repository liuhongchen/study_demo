package 练习.树;

/**
 * ClassName:_701_BST插入
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-08 10:49
 * @author:892698613@qq.com
 */
public class _701_BST插入 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null)return new TreeNode(val);

        TreeNode dummy=root;
        TreeNode temp=root;
        while (dummy!=null){
            temp=dummy;
            if (dummy.val==val){
                return root;
            }else if (dummy.val>val){
                dummy=dummy.left;
            }else{
                dummy=dummy.right;
            }
        }
        if (temp.val>val){
            temp.left=new TreeNode(val);
        }else {
            temp.right=new TreeNode(val);
        }

        return root;

    }
}

package 练习.树;

/**
 * ClassName:_129_求根到叶子节点数字之和
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-17 20:27
 * @author:892698613@qq.com
 */
public class _129_求根到叶子节点数字之和 {

    private int ans;
    public int sumNumbers(TreeNode root) {
        if(root==null)return ans;

        ans=0;

        dodo(root,"");

        return ans;

    }


    private void dodo(TreeNode root,String before){
        String newBefore=before+root.val;
        if (root.left==null&&root.right==null){
            ans+=Integer.parseInt(newBefore);
        }else{
            if(root.left!=null)dodo(root.left,newBefore);
            if(root.right!=null)dodo(root.right,newBefore);
        }
    }

}

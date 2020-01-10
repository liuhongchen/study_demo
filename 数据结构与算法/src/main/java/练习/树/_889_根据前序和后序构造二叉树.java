package 练习.树;

import java.util.Arrays;

/**
 * ClassName:_889_根据前序和后序构造二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 15:41
 * @author:892698613@qq.com
 */
public class _889_根据前序和后序构造二叉树 {


    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre==null||post==null||pre.length==0||post.length==0)return null;
        if (pre.length==1)return new TreeNode(pre[0]);


        int rootVal=pre[0];
        TreeNode root=new TreeNode(pre[0]);

        int len=pre.length;
        int l=0;
        for (int i=1;i<len;i++){
            if (pre[1]==post[i]){
                l=i;
            }
        }

        root.left=constructFromPrePost(Arrays.copyOfRange(pre,1,l+2)
                ,Arrays.copyOfRange(post,0,l+1));
        root.right=constructFromPrePost(Arrays.copyOfRange(pre,l+2,len)
                ,Arrays.copyOfRange(post,l+1,len-1));


        return root;

    }


}


package 练习.树;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_95_不同的BST2
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 17:23
 * @author:892698613@qq.com
 */
public class _95_不同的BST2 {

    List<TreeNode> ans;

    public List<TreeNode> generateTrees(int n) {
        ans=new ArrayList<>();

        generate(n,1,null);
        return ans;

    }

    public TreeNode generate(int n,int base,TreeNode parent){
        if (n<=0) {
            return null;
        }else if (n==1) {
            return new TreeNode(base);
        }


        //i是root的val
        for (int i=base;i<=n;i++){
            TreeNode root=new TreeNode(i);
            if (parent==null)parent=root;
            generate(i-base,base,parent);
            generate(n-i,i+1,parent);

        }

    }

}

package 练习.树;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_894_所有可能的满二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 08:21
 * @author:892698613@qq.com
 */
public class _894_所有可能的满二叉树 {

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list=new ArrayList<>();
        if (n%2==0)return list;
        if (n==1) {
            list.add(new TreeNode(0));
            return list;
        }
        for (int i=1;i<n-1;i+=2){
            for (TreeNode left:allPossibleFBT(i)){
                for (TreeNode right:allPossibleFBT(n-i-1)){
                    TreeNode node=new TreeNode(0);
                    node.left=left;
                    node.right=right;
                    list.add(node);
                }
            }
        }
        return list;

    }

    @Test
    public void test(){
        List<TreeNode> list = allPossibleFBT(7);
        System.out.println(list);
    }

}

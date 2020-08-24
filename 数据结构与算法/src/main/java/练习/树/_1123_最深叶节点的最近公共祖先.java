package 练习.树;

import model.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * ClassName:_1123_最深叶节点的最近公共祖先
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 10:31
 * @author:892698613@qq.com
 */
public class _1123_最深叶节点的最近公共祖先 {

    Map<TreeNode,TreeNode> map;
    List<TreeNode> list;
    int max=-1;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root==null)return null;


        map=new HashMap<>();
        list=new ArrayList<>();

        traversal(root,0);

        if(list.size()==1)return list.get(0);

        for (int i=1;i<max;i++){
            Set<TreeNode> set=new HashSet();
            for (TreeNode node:list){
                for (int j=0;j<i;j++) {
                    node = map.get(node);
                }
                set.add(node);
            }
            if (set.size()==1) return set.iterator().next();

        }

        return null;



    }


    public void traversal(TreeNode root,int depth){
        depth++;
        if (root.left!=null) {
            map.put(root.left,root);
            traversal(root.left, depth);
        }
        if (root.right!=null){
            map.put(root.right,root);
            traversal(root.right,depth);
        }

        if(depth>max){
            list=new ArrayList<>();
            max=depth;
            list.add(root);
        }else if (depth==max){
            list.add(root);
        }

    }


    @Test
    public void test(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        lcaDeepestLeaves(root);
    }
}

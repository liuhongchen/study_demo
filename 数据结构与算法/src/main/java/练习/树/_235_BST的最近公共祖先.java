package 练习.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName:_235_BST的最近公共祖先
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-09 11:30
 * @author:892698613@qq.com
 */
public class _235_BST的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||p==null||q==null)return null;

        //左true 右false
        Queue<Boolean> routes1=new LinkedList<>();
        Queue<Boolean> routes2=new LinkedList<>();

        TreeNode node=root;

        while (node!=null){
            if (node==p) {
                break;
            }else if (p.val<node.val){
                node=node.left;
                routes1.offer(true);
            }else {
                node=node.right;
                routes1.offer(false);
            }
        }

        node=root;
        while (node!=null){
            if (node==q) {
                break;
            }else if (q.val<node.val){
                node=node.left;
                routes2.offer(true);
            }else {
                node=node.right;
                routes2.offer(false);
            }
        }

        while (root!=null&&!routes1.isEmpty()&&!routes2.isEmpty()){
            boolean b1=routes1.poll();
            boolean b2=routes2.poll();
            if (b1==b2){
                if (b1){
                    root=root.left;
                }else{
                    root=root.right;
                }
            }else{
                return root;
            }
        }

        return root;

    }

}

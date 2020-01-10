package 练习.树;

import java.util.*;

/**
 * ClassName:_429_N叉树的层序遍历
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 09:53
 * @author:892698613@qq.com
 */
public class _429_N叉树的层序遍历 {

    private List<List<Integer>> ans;


    /**
     * 递归方式
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        ans=new ArrayList<>();
        if (root==null)return ans;
        dodo(root,0);
        return ans;
    }

    public void dodo(Node root,int depth){
        depth++;
        if (ans.size()<depth)ans.add(new ArrayList<>());
        List<Integer> list = ans.get(depth - 1);
        list.add(root.val);
        if (root.children!=null&&root.children.size()>0){
            for (Node child:root.children){
                dodo(child,depth);
            }
        }
    }


    /**
     * 队列方式
     */
    public List<List<Integer>> levelOrder2(Node root){
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node node=queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            res.add(level);
        }
        return res;
    }
}

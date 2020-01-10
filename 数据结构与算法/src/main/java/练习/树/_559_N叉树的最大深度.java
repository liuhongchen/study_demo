package 练习.树;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:_559_N叉树的最大深度
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 12:36
 * @author:892698613@qq.com
 */
public class _559_N叉树的最大深度 {
    public int maxDepth(Node root) {
        if(root==null)return 0;
        if (root.children==null||root.children.size()==0){
            return 1;
        }

        List<Integer> arr=new ArrayList<>();
        for (Node child:root.children){
            arr.add(maxDepth(child));
        }
        return 1+findMax(arr);
    }


    private int findMax(List<Integer> arr){
        int max=arr.get(0);
        for (Integer i:arr){
            if (i>max)max=i;
        }
        return max;
    }

}

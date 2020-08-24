package 练习.树;

import model.TreeNode;

/**
 * ClassName:ListToTree
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-04 15:11
 * @author:892698613@qq.com
 */
public class TreeUtil {

    public static TreeNode createTreeNode(Integer[] arr){
        return createTreeNode(arr,0);
    }

    private static TreeNode createTreeNode(Integer[] arr,int index){
        if (arr[index]==null)return null;
        TreeNode node=new TreeNode(arr[index]);
        if (2*index+2<arr.length){
            node.left=createTreeNode(arr,2*index+1);
            node.right=createTreeNode(arr,2*index+2);
        }
        return node;
    }


}


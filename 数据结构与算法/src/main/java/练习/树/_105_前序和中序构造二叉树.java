package 练习.树;

import model.TreeNode;

/**
 * ClassName:_105_前序和中序构造二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-06 10:10
 * @author:892698613@qq.com
 */
public class _105_前序和中序构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||preorder.length==0)return null;
        if (preorder.length==1)return new TreeNode(preorder[0]);
        int rootVal=preorder[0];
        int rootIndex=findIndex(inorder,rootVal);
        TreeNode treeNode=new TreeNode(rootVal);

        int leftLen=rootIndex;
        int rightLen=inorder.length-leftLen-1;

        int[] leftInOrder=new int[leftLen];
        System.arraycopy(inorder,0,leftInOrder,0,leftLen);
        int[] leftPreOrder=new int[leftLen];
        System.arraycopy(preorder,1,leftPreOrder,0,leftLen);

        int[] rightInOrder=new int[rightLen];
        System.arraycopy(inorder,rootIndex+1,rightInOrder,0,rightLen);
        int[] rightPreOrder=new int[rightLen];
        System.arraycopy(preorder,leftLen+1,rightPreOrder,0,rightLen);

        treeNode.left=buildTree(leftPreOrder,leftInOrder);
        treeNode.right=buildTree(rightPreOrder,rightInOrder);
        return treeNode;


    }


    public int findIndex(int[] arr,int val){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==val){
                return i;
            }
        }
        return -1;
    }

}

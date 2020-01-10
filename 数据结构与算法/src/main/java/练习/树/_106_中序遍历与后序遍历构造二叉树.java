package 练习.树;

import org.junit.Test;

/**
 * ClassName:_106_中序遍历与后序遍历构造二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-05 20:17
 * @author:892698613@qq.com
 */
public class _106_中序遍历与后序遍历构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int inLeftIndex,int inRightIndex,int[] postorder, int postLeftIndex,int postRightIndex) {
        if (inorder==null||postorder==null||inorder.length==0||(inRightIndex-inLeftIndex)==0)return null;
        if (inorder.length==1||(inRightIndex-inLeftIndex)==1)return new TreeNode(inorder[0]);
        int rootVal=postorder[postorder.length-1];
        TreeNode result=new TreeNode(rootVal);
        int inRootIndex=inLeftIndex;
        for (int i=inLeftIndex;i<inRightIndex;i++){
            if (inorder[i]==rootVal){
                inRootIndex=i;
                break;
            }
        }
//        int[] leftInOrder=new int[inRootIndex];
//        System.arraycopy(inorder,0,leftInOrder,0,leftInOrder.length);
//        int[] rightInOrder=new int[inorder.length-inRootIndex-1];
//        System.arraycopy(inorder,inRootIndex+1,rightInOrder,0,rightInOrder.length);
//
//        int[] leftPostOrder=new int[inRootIndex];
//        System.arraycopy(postorder,0,leftPostOrder,0,leftInOrder.length);
//        int[] rightPostOrder=new int[inorder.length-inRootIndex-1];
//        System.arraycopy(postorder,inRootIndex,rightPostOrder,0,rightInOrder.length);


        result.left=buildTree(inorder,inLeftIndex,inRootIndex-1
                ,postorder,postLeftIndex,postLeftIndex+inRootIndex-inLeftIndex-1);
        result.right=buildTree(inorder,inRootIndex+1,inRightIndex
                ,postorder,inRootIndex,postRightIndex);
        return result;
    }


        @Test
    public void test(){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode node = buildTree(inorder, postorder);
        System.out.println(node);
    }
}

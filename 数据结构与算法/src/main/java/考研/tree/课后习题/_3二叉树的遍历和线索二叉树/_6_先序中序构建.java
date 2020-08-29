package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;
import utils.MyUtil;

public class _6_先序中序构建 {


    /**
     * 递归算法
     * @param arr 先序序列
     * @param brr 中序
     */
    public TreeNode m1(int[] arr,int[] brr){
        int rootVal=arr[0];
        int index=-1;
        TreeNode root=new TreeNode(rootVal);

        for (int i = 0; i < brr.length; i++) {//遍历中序序列寻找根节点值的索引
            if (brr[i]==rootVal){
                index=i;
                break;
            }
        }

        if (index==-1)return null;//中序中未找到根节点对应值


        //index=5
        if (index<=0){
            root.left=null;
        }else {
            int[] lPre = new int[index];
            System.arraycopy(arr, 1, lPre, 0, index);
            int[] lIn = new int[index];
            System.arraycopy(brr, 0, lIn, 0, index);
            root.left = m1(lPre, lIn);
        }
        //index=5
        int rLen=arr.length-1-index;
        if (rLen==0){
            root.right=null;
        }else {
            int[] rPre = new int[rLen];
            System.arraycopy(arr, index + 1, rPre, 0, rLen);
            int[] rIn = new int[index];
            System.arraycopy(brr, index + 1, rIn, 0, rLen);
            root.right = m1(rPre, rIn);
        }
        return root;


    }

    @Test
    public void test(){
        int[] arr={1,2,4,8,9,5,3,6,7};
        int[] brr={8,4,9,2,5,1,6,3,7};

        TreeNode treeNode = m1(arr, brr);
        System.out.println();
    }
}

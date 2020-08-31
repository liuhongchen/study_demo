package 考研.tree.课后习题._3二叉树的遍历和线索二叉树;

import model.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class _15_满二叉树由先序构建后序 {


    public TreeNode m1(int[] arr){
        if (arr==null||arr.length==0)return null;

        int len=arr.length;

        //判断数组长度是否合法（符合满二叉树个数）
        int i=0;
        while (true){
            if (len+1==(Math.pow(2,i)))break;
            if (len+1<(Math.pow(2,i)))return null;
            i++;
        }


        TreeNode root=new TreeNode(arr[0]);

        if (len<=1)return root;//叶子节点传进来的数组长度为1，不需要执行下面的步骤

        int childLen=len/2;

        int[] leftChildPre=new int[childLen];
        System.arraycopy(arr,1,leftChildPre,0,childLen);

        root.left=m1(leftChildPre);

        int[] rightChildPre=new int[childLen];
        System.arraycopy(arr,1+childLen,rightChildPre,0,childLen);

        root.right=m1(rightChildPre);
        return root;
    }


    @Test
    public void test() {
        int[] arr={1,2,4,5,3,6,7};
        TreeNode treeNode = m1(arr);
        System.out.println(treeNode);
    }
}

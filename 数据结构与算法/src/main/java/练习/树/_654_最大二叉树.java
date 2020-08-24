package 练习.树;

import model.TreeNode;
import org.junit.Test;

/**
 * ClassName:_654_最大二叉树
 * Package:练习.树
 * Description:
 *
 * @date:2020-01-04 21:58
 * @author:892698613@qq.com
 */
public class _654_最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums==null||nums.length==0)return null;
        int maxIndex = findMaxIndex(nums);
        TreeNode treeNode=new TreeNode(nums[maxIndex]);

        if (maxIndex>0) {
            int[] left=new int[maxIndex];
            System.arraycopy(nums, 0, left, 0, left.length);
            treeNode.left= constructMaximumBinaryTree(left);
        }
        if(maxIndex<nums.length-1) {
            int[] right = new int[nums.length - maxIndex -1];
            System.arraycopy(nums, maxIndex + 1, right, 0, right.length);
            treeNode.right= constructMaximumBinaryTree(right);
        }
        return treeNode;
    }


    public int findMaxIndex(int[] nums){
        int maxIndex=0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[maxIndex])maxIndex=i;
        }
        return maxIndex;
    }


    @Test
    public void test(){
        int[] arr={3,2,1,6,0,5};

        TreeNode treeNode = constructMaximumBinaryTree(arr);
        System.out.println(treeNode);
    }
}

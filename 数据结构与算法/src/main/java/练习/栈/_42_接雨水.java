package 练习.栈;

import java.awt.*;
import java.util.Stack;

public class _42_接雨水 {

    public static int trap(int[] height) {

        if (height == null || height.length < 3) return 0;

        int count = 0;
        int len = height.length;
        int indexSlow = 0;
        int indexFast = indexSlow + 1;
//        while (height[indexSlow] < height[indexFast]) {
//            indexSlow++;
//            indexFast++;
//        }
        int biggestIndex=indexFast;

        while (indexSlow < len-1) {

            if (height[indexFast]>=height[indexSlow]){
                count+=getRes(height,indexSlow,indexFast);
                indexSlow=indexFast;
                indexFast=indexSlow+1;
                biggestIndex=indexFast;
            }else{
                if (height[indexFast]>height[biggestIndex])biggestIndex=indexFast;
                indexFast++;
            }
            if (indexFast == len&&height[indexFast-1]<height[indexSlow]){
                count += getRes(height, indexSlow, biggestIndex);
                indexSlow=biggestIndex;
                indexFast=indexSlow+1;
                biggestIndex=indexFast;
            }

        }
        return count;
    }

    public static int getRes(int[] height, int indexSlow, int indexFast) {
        int slow = height[indexSlow];
        int fast = height[indexFast];
        int min = Math.min(fast, slow);
//        int res = Math.min(fast, slow) * (indexFast - indexSlow - 1);
        int res = 0;
        for (int i = indexSlow + 1; i < indexFast; i++) {
            if (height[i] >= min) continue;
            res += (min - height[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {5,4, 1, 2};
//        int[] arr = {5,2,1,2,1,5};
//        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr = {6,9,8,3,9,7,5};
        System.out.println(trap(arr));
    }

    public static int trap2(int[] height) {
        if (height == null || height.length < 3) return 0;

        int count = 0;
        int len = height.length;
        int indexSlow = 0;
        int indexFast = indexSlow + 1;
        while (height[indexSlow] < height[indexFast]) {
            indexSlow++;
            indexFast++;
        }
        int res=0;
        while (indexSlow < len-1) {
            Stack<Integer> stack=new Stack<>();
            int maxIndex=indexFast;
            int slow=height[indexSlow];
            boolean flag=false;
            for (int i = indexSlow+1; i <len;i++){
                if (height[i]>height[maxIndex]){
                    maxIndex=i;
                }
                if (height[i]>=slow){
                    while (stack.size()>0){
                        Integer pop = stack.pop();
                        res+=(slow-pop);
                    }
                    flag=true;
                    indexSlow=i;
                    break;
                }else{
                    stack.push(height[i]);
                }
            }
            if (!flag){
                indexSlow++;
            }
        }
        return res;
    }
}
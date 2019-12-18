package 练习.栈;

import java.util.Stack;

public class _503_下一个更大元素2 {

    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                Integer pop = stack.pop();
                res[pop] = num;

            }
            stack.push(i);
        }

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                Integer pop = stack.pop();
                res[pop] = num;

            }
        }

        while (stack.size()>0){
            Integer pop = stack.pop();
            res[pop]=-1;
        }

        return res;


    }

    public static void main(String[] args) {
        int[] arr={1,2,1,3};
        System.out.println(nextGreaterElements(arr));
    }
}

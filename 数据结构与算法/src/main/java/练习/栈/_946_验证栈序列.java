package 练习.栈;

import java.util.Stack;

public class _946_验证栈序列 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;


    }

    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5};
        int[] arr2={4,3,5,1,2};
        System.out.println(validateStackSequences(arr1, arr2));
    }
}

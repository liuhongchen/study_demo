package 练习.栈;

import java.util.Stack;

public class _1209_删除字符串中所有相邻重复项 {


    public static String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return s;
        if (k == 1) return "";

        int len = s.length();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (stack.size() < k - 1) {
                stack.push(c);
            } else {
                for (int j = 0; j < k - 1; j++) {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        for (int m = 0; m < j; m++) {
                            stack.push(c);
                        }
                        stack.push(c);
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "nnwssswwnvbnnnbbqhhbbbhmmmlllm";
        removeDuplicates(s, 3);
    }
    public static String removeDuplicates2(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return s;
        char last = s.charAt(0);
        int count = 1;
        int position = -1;
        for (int i = 1; i < s.length(); i++) {
            if(last==s.charAt(0)){
                count++;
                if(count == k){
                    position = i;
                    break;
                }
            }
            else {
                last = s.charAt(0);
                count=1;
            }
        }
        if(position==-1)
            return s;
        else{
            String ns = s.substring(0, position - k+1) + s.substring(position+1);
            return removeDuplicates(ns,k);
        }



    }
}
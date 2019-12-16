package 练习.栈;

import java.util.Stack;

public class _1021_删除最外层的括号 {

    public static String removeOuterParentheses(String S) {
        if (S==null||S.length()==0) return S;

        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<Character>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == '(') {
                if (stack.size()>0)result.append(c);
                stack.push(c);
            } else {
                Character left = stack.pop();
                if (stack.size() >0) result.append(c);
            }

        }
        return result.toString();

    }

    public static void main(String[] args) {
        String s="(()())(())(()(()))";
        String s1 = removeOuterParentheses(s);
        System.out.println(s1);
    }
}

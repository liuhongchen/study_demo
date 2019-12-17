package 练习.栈;

import java.util.Stack;

public class _1003_检查替换后的词是否有效 {


    public static void main(String[] args) {
        String s = "cababc";
        System.out.println(isValid2(s));
    }


    public static boolean isValid(String S) {
        if (S == null || S.isEmpty()) return false;
        while (S.contains("abc")) {
            S = S.replaceAll("abc", "");
        }

        return S.length() == 0;
    }

    public static boolean isValid2(String S) {
        if (S == null || S.isEmpty()) return false;
        Stack<Character> stack = new Stack<>();
        int len = S.length();

        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == 'c') {
                if (stack.size()<2)return false;
                Character pop1 = stack.pop();
                Character pop2 = stack.pop();
                if (!(pop1 == 'b') || !(pop2 == 'a')) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size()==0;
    }
}
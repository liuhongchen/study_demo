package 练习.栈;

import java.util.ArrayList;
import java.util.Stack;

/**
 * nac
 */
public class _1249_移除无效的括号 {

    public static String minRemoveToMakeValid(String s) {
        if (s == null || s.isEmpty()) return s;


        Stack<Character> stack = new Stack<>();
        int deep = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deep--;
                stack.push(c);

            } else if (c == ')') {
                if (deep < 0) {
                    deep++;
                    stack.push(c);

                }
            } else {

                stack.push(c);
            }
        }


        deep = 0;
        Stack<Character> stack1 = new Stack<>();
        while (stack.size() > 0) {
            char c = stack.pop();
            if (c == ')') {
                deep--;
                stack1.push(c);

            } else if (c == '(') {
                if (deep < 0) {
                    deep++;
                    stack1.push(c);

                }
            } else {
                stack1.push(c);

            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack1.size() > 0) {
            sb.append(stack1.pop());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "())()(((";
        System.out.println(minRemoveToMakeValid2(s));
    }

    public static String minRemoveToMakeValid2(String s) {
        Stack<Character> stack = new Stack<>();
        int deep = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                deep--;
                stack.push(c);

            } else if (c == ')') {
                if (deep < 0) {
                    deep++;
                    stack.push(c);

                }
            } else {

                stack.push(c);
            }
        }
        Stack<Character> stack1=new Stack<>();
        while (stack.size()>0){
            Character pop = stack.pop();
            if (deep<0&&pop=='('){
                deep++;
            }else{
                stack1.push(pop);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (stack1.size()>0){
            sb.append(stack1.pop());
        }
        return sb.toString();
    }


}
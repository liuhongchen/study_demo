package 练习.栈;

import java.util.Stack;

public class _844_比较含退格的字符串 {

    /**
     * 字符串做法不好，效率低
     * @param S
     * @param T
     * @return
     */
    public static boolean backspaceCompare(String S, String T) {

        if ((S==null&&T!=null)||(S!=null&&T==null)) return false;
        if (S==null&&T==null)return true;

//        Stack<Character> stack1=toStack(S);
//        Stack<Character> stack2=toStack(T);
//        if (stack1.size()!=stack2.size())return false;
//
//        return stack1.equals(stack2);


        String s1=toString(S);
        String s2=toString(T);
        if (s1.length()!=s2.length())return false;
        return s1.equals(s2);
    }

    public static String toString(String s){
        Stack<Character> stack=new Stack<>();
        int len=s.length();
        for (int i=0;i<len;i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }
    public static Stack<Character> toStack(String s){
        Stack<Character> stack=new Stack<>();
        int len=s.length();
        for (int i=0;i<len;i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        String s1="a#c";
        String s2="b";
        System.out.println(backspaceCompare(s1, s2));
    }
}

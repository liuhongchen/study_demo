package 练习.栈;

import java.util.Stack;

public class _921_使括号有效的最少添加 {

    public static int minAddToMakeValid(String S) {
        if (S==null||S.isEmpty())return 0;

        Stack<Character> stack=new Stack<>();
        int count=0;
        int len=S.length();
        for (int i=0;i<len;i++){
            char c=S.charAt(i);
            if (c=='('){
                stack.push(c);
            }else{
                if (stack.size()==0) {
                    count++;
                }else{
                    stack.pop();
                }
            }
        }
        if (stack.size()>0){
            count=count+stack.size();
        }
        return count;
    }

    public static void main(String[] args) {
        String s="()))((";
        System.out.println(minAddToMakeValid(s));
    }
}

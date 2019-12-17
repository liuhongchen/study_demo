package 练习.栈;

import java.util.Stack;

public class _1047_删除字符串中的所有相邻重复项 {

    public static String removeDuplicates(String S) {
        if (S==null|| S.isEmpty())return S;

        Stack<Character> stack=new Stack<>();
        int len = S.length();
        for (int i=0;i<len;i++){
            char c=S.charAt(i);
            if (stack.size()==0){
                stack.push(c);
            }else {
                if (stack.peek()!=c){
                    stack.push(c);
                }else{
                    stack.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (char c:stack){
            sb.append(c);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String s="abbaca";
        System.out.println(removeDuplicates(s));
    }

}

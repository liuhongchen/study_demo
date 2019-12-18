package 练习.栈;

import java.util.ArrayList;
import java.util.Stack;

public class _1190_反转每对括号间的字符串 {

    public static String reverseParentheses(String s) {
        if (s==null||s.isEmpty())return s;

        Stack<Character> stack=new Stack<>();
        int len=s.length();
        for (int i=0;i<len;i++){
            char c=s.charAt(i);
            if (c==')'){
                ArrayList<Character> arrayList=new ArrayList<>();
                while (stack.peek()!='('){
                    arrayList.add(stack.pop());
                }
                stack.pop();//这个是把(出栈
                for (Character cc:arrayList){
                    stack.push(cc);
                }
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        for (Character c:stack){
            sb.append(c);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
//        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }
}

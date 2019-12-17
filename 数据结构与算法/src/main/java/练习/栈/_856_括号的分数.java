package 练习.栈;

import java.util.Stack;

public class _856_括号的分数 {

    public static int scoreOfParentheses(String S) {
        if (S==null||S.isEmpty())return 0;

        Stack stack=new Stack<>();
        int len=S.length();
        for (int i=0;i<len;i++){
            char c=S.charAt(i);
            if (c=='('){
                stack.push(c);
            }else{
                if (stack.peek().toString().equals("(")){
                    stack.pop();
                    stack.push(1);
                }else{
                    Stack<Integer> stack1=new Stack<>();
                    while (!stack.peek().toString().equals("(")){
                        stack1.push(Integer.parseInt(stack.pop().toString()));
                    }
                    int temp=0;
                    for (Integer ii:stack1){
                        temp+=ii;
                    }
                    stack.pop();
                    temp*=2;
                    stack.push(temp);
                }
            }
        }
        int result=0;
        for (Object o:stack){
            result+=Integer.parseInt(o.toString());
        }

        return result;
    }

    public static void main(String[] args) {
        String s="()()";
        System.out.println(scoreOfParentheses(s));
    }

}

package 练习.栈;

import java.util.Stack;

public class _150_逆波兰表达式 {
    public static int evalRPN(String[] tokens) {
        if (tokens==null||tokens.length==0)return 0;

        int len=tokens.length;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<len;i++){
            switch (tokens[i]){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    Integer pop3 = stack.pop();
                    Integer pop4 = stack.pop();
                    stack.push(pop4-pop3);
                    break;
                case "*":

                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    Integer pop7 = stack.pop();
                    Integer pop8 = stack.pop();
                    stack.push(pop8/pop7);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens={"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
}

package 练习.栈;

import java.util.List;
import java.util.Stack;

public class _770_基本计算器4 {

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {

        int len=evalints.length;
        for (int i=0;i<len;i++){
            expression=expression.replaceAll(evalvars[i],String.valueOf(evalints[i]));
        }
        String[] tokens=expression.split(" ");
        Stack<String> stack=new Stack<>();

        for (String token:tokens){
            switch (token){
                case "+":

            }
        }
        return null;
    }
}

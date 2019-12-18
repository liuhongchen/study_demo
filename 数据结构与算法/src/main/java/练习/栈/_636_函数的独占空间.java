package 练习.栈;

import java.util.*;

public class _636_函数的独占空间 {


    public static int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null) return null;
        if (logs.size() == 0) return new int[0];


        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        int other=0;
        for (String log : logs) {
            String[] strArr = log.split(":");
            int id = Integer.parseInt(strArr[0]);
            int time = Integer.parseInt(strArr[2]);
            while (stack.size() > 0 && stack.peek()[0] == id) {

                int[] pop = stack.pop();
                int before = pop[1];
                int t = time - before-other;
                res[pop[0]] = t;
                other+=t;

            }
            other=0;
            int[] entry = {id, time};
            stack.push(entry);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        exclusiveTime(2, logs);

    }

}

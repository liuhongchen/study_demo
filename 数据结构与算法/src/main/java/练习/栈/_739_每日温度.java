package 练习.栈;


import java.util.Stack;

public class _739_每日温度 {

    public static int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return T;

        int len = T.length;
        for (int i = 0; i < len; i++) {
            int tmp = T[i];
            if (i + 1 < len && T[i + 1] > tmp) {
                T[i] = 1;
                continue;
            }
            int count = 0;
            boolean flag = false;
            for (int j = i + 1; j < len; j++) {
                count++;
                if (T[j] > T[i]) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                T[i] = count;
            } else {
                T[i] = 0;
            }
        }
        return T;
    }

    public static void main(String[] args) {

        int[] list = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(list).toString());
    }

    public static int[] dailyTemperatures2(int[] T) {
        if (T==null||T.length==0)return T;

        Stack<Integer> stack=new Stack<Integer>();
        int len=T.length;
        int[] res=new int[len];
        for (int i=0;i<len;i++){
            int tmp=T[i];
            while (!stack.isEmpty()&&T[stack.peek()]<tmp){
                Integer pop = stack.pop();
                res[pop]=(i-pop);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            res[pop]=0;
        }
        return res;
    }
}

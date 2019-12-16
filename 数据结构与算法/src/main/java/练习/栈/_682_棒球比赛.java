package 练习.栈;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class _682_棒球比赛 {

    public static int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;

        int result = 0;

        Set<String> set = new HashSet<>();
        set.add("C");
        set.add("D");
        set.add("+");
        int len = ops.length;
        for (int i = 0; i < len; i++) {
            switch (ops[i]) {
                case "C":
                    for (int j = i - 1; j >= 0; j--) {
                        if (!set.contains(ops[j])) {
                            if (ops[j] != null) {
                                int score = Integer.parseInt(ops[j]);
                                result -= score;
                                ops[j] = null;
                                break;
                            }
                        }
                    }
                    break;
                case "+":
                    int count = 0;
                    int score = 0;
                    for (int j = i - 1; j >= 0; j--) {
                        if (count == 2) break;
                        if (!set.contains(ops[j])) {
                            if (ops[j] != null) {
                                score += Integer.parseInt(ops[j]);
                                count++;

                            }
                        }
                    }
                    ops[i] = String.valueOf(score);
                    result += score;
                    break;
                case "D":

                    for (int j = i - 1; j >= 0; j--) {
                        if (!set.contains(ops[j])) {
                            if (ops[j] != null) {
                                result += (2 * Integer.parseInt(ops[j]));
                                ops[i] = String.valueOf(2 * Integer.parseInt(ops[j]));
                                break;
                            }
                        }
                    }
                    break;
                default:
                    result += (Integer.parseInt(ops[i]));
            }
        }
        return result;


    }

    public static void main(String[] args) {
        String[] s = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(s));
    }


}
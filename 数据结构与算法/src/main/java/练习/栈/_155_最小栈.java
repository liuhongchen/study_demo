package 练习.栈;


import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class _155_最小栈 {

    class MinStack {

        TreeMap<Integer,Integer> map=new TreeMap<>();
        Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else {
                map.put(x,1);
            }
        }

        public void pop() {
            Integer pop = stack.pop();
            Integer value = map.get(pop);
            if (value==1){
                map.remove(pop);
            }else{
                map.put(pop,value-1);
            }

        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
           return map.firstKey();
        }
    }
}

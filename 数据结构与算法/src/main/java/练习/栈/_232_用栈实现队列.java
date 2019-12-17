package 练习.栈;

import java.util.Stack;

public class _232_用栈实现队列 {

    class MyQueue {


        Stack<Integer> master;
        Stack<Integer> slave;

        /** Initialize your data structure here. */
        public MyQueue() {
            master=new Stack<>();
            slave=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (master.size()==0){
                master.push(x);
            }else{
                while (master.size()>0){
                    slave.push(master.pop());
                }
                master.push(x);
                while (slave.size()>0){
                    master.push(slave.pop());
                }
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return master.pop();
        }

        /** Get the front element. */
        public int peek() {
            return master.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return master.size()==0;
        }
    }

}

package 考研.栈与队列.栈;

import java.util.Stack;

public class P85_3 {

    public Stack<Integer> s1=new Stack<Integer>();//主栈
    public Stack<Integer> s2=new Stack<Integer>();//辅助栈


    public void enQueue(int val){
        while (s1.size()>0){
            s2.push(s1.pop());
        }
        s1.push(val);
        while (s2.size()>0){
            s1.push(s2.pop());
        }
    }

    public Integer deQueue(int val){
        if (s1.size()<=0)return null;

        return s1.pop();
    }

    public Boolean isEmpty(){
        return s1.size()==0;
    }
}

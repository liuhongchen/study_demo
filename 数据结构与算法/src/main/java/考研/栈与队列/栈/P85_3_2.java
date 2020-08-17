package 考研.栈与队列.栈;

import java.util.Stack;

public class P85_3_2 {

    public Stack<Integer> s1=new Stack<Integer>();//入栈
    public Stack<Integer> s2=new Stack<Integer>();//出栈


    public void enQueue(int val){
        s1.push(val);
    }

    public Integer deQueue(int val){
        if (s2.size()>0)return s2.pop();

        while (s1.size()>0){
            s2.push(s1.pop());
        }
        if (s2.size()==0)return null;

        return s2.pop();
    }

    public Boolean isEmpty(){
        return s1.size()==0&&s2.size()==0;
    }
}

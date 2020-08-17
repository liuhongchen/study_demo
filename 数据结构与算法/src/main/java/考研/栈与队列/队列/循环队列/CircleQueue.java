package 考研.栈与队列.队列.循环队列;

public class CircleQueue {

    private Integer maxSize=10;
    public Integer[] arr;

    public int front=0;//指向头元素
    public int rear=0;//指向尾元素

    public CircleQueue() {
        arr=new Integer[maxSize];
    }

    public CircleQueue(Integer maxSize) {
        this.maxSize = maxSize;
        arr=new Integer[maxSize];
    }

    public void enQueue(int val){
        if ((rear+1)%maxSize==front)return;//队满
        arr[rear]=val;
        rear=(rear+1)%maxSize;
    }

    public Integer deQueue(){
        if (isEmpty())return null;
        int val=arr[front];
        arr[front]=null;
        front=(front+1)%maxSize;
        return val;
    }

    public Boolean isEmpty(){
        return rear==(front+1)%maxSize;
    }


}

package com.d02_ArrayList;

@SuppressWarnings("unchecked")
public class MyArrayList<E> {


    private int size=0;

    private E[] arr;


    private static final int DEFAULT_CAPACITY=10;

    private static final float loadFactor=0.75f;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        arr= (E[]) new Object[Math.max(capacity, DEFAULT_CAPACITY)];
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index>=size||index<0){
            throw new IndexOutOfBoundsException("数组越界!");
        }
        return this.arr[index];
    }

    public E set(int index, E element){
        E old=arr[index];
        this.arr[index]=element;
        return old;
    }

    public int size(){
        return this.size;
    }


    public boolean isEmpty(){
        return size==0;
    }

    public boolean contains(E element){
        for(E i:arr){
            if (i.equals(element)){
                return true;
            }
        }
        return false;
    }

    public boolean clear(){
        //这里只是清掉size即可,下次如果还用的话,之前申请的内存可以复用,
        //如果清掉数组,再申请的话太浪费时间了,浪费性能
        //那如果极端情况,之前有一万个,现在只需要十个,就搞个阈值,超过清空,不超过size=0
        if (size<=100){
            for (int i=0;i<size;i++){
                arr[i]=null;
            }
            this.size=0;
        }else{
            this.arr= (E[]) new Object[DEFAULT_CAPACITY];
            this.size=0;
        }
        return true;
    }

    public E remove(int index){
        E old=arr[index];
        for(int i=index;index<size-1;i++){
            arr[i]=arr[i+1];
        }

        arr[--size]=null;
        return old;
    }

    public int indexOf(E element){
        for (int index=0;index<arr.length;index++){
            if (arr[index].equals(element)) return index;
        }
        return -1;
    }


    public int add(E element){
        if (size>=arr.length*loadFactor) {
            enlarge();
        }
        arr[size++]=element;

        return size-1;
    }

    public E add(int index, E element){
        if (index>arr.length-1){
            enlarge(index+1);
        }
        if (size>=arr.length*loadFactor){
            enlarge();
        }
        //注意,要先从大的开始挪动
        for (int i=size-1;i>index;i++){
            arr[i]=arr[i-1];
        }
        arr[index]=element;
        size++;
        return arr[index];
    }

    private void enlarge() {
        //这里其实就是1.5倍,但是java底层如果用浮点数计算的话影响性能,所以用右移,
        enlarge(arr.length+(arr.length>>1));
    }
    private void enlarge(int capacity) {
        E[] newArr= (E[]) new Object[capacity];
        if (size >= 0) System.arraycopy(arr, 0, newArr, 0, size);
        arr=newArr;
    }

    @Override
    public String toString() {
        if (arr == null)
            return "[]";
        int iMax = size-1;
        if (iMax==-1){
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }


    public static void main(String[] args) {
            MyArrayList myArrayList=new MyArrayList();
            myArrayList.add(1);
            myArrayList.add(2);
            System.out.println(myArrayList);
    }
}

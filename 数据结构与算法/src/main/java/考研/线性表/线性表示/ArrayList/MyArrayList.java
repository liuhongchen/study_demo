package 考研.线性表.线性表示.ArrayList;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MyArrayList {

    public Integer[] arr;
    public Integer size;

    public MyArrayList(Integer length){
        initList(length);
    }
    public MyArrayList(){
        initList(10);
    }



    public void initList(Integer length){
        arr=  new Integer[length];
        size=0;
    }

    public Integer length(){
        return size;
    }

    public Integer getElem(Integer i){
        return arr[i];
    }

    public Integer LocateElem(Integer e){
        if (arr==null||size==0||e==null)return null;

        for (int i = 0; i < arr.length; i++) {
            if (e.equals(arr[i]))return i;
        }
        return -1;
    }

    public void add(Integer e){
        judgeCapacity();
        arr[size]=e;
        size++;
    }

    public void insert(Integer pos,Integer e){
        if (pos<0||pos>=arr.length)return;
        size++;
        judgeCapacity();
        for (int j =size-1 ; j >= pos; j--) {
            arr[j+1]=arr[j];
        }
        arr[pos]=e;
    }

    public void remove(Integer e){
        for (int i = 0; i < size; i++) {
            if (e.equals(arr[i])){
                arr[i]=null;

                for (int j = i; j < size - 1; j++) {
                    arr[j]=arr[j+1];
                }
                arr[size-1]=null;
                size--;
                return;
            }
        }
    }

    public Boolean isEmpty(){
        return size==0;
    }




    public void judgeCapacity(){
        if (size>=((int)(0.75*arr.length))){
            enlarge();
        }else if (size<=((int)(0.1*arr.length))){
            reduce();
        }
    }

    public Integer enlarge(){
        Integer newSize=(int)(1.5*arr.length);
        Integer[] newArr=new Integer[newSize];
        System.arraycopy(arr,0,newArr,0,size);
        arr=newArr;
        return newSize;

    }
    public Integer reduce(){
        Integer newSize=(int)(0.75*arr.length);
        Integer[] newArr=  new Integer[newSize];
        System.arraycopy(arr,0,newArr,0,size);
        arr=newArr;
        return newSize;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }


}

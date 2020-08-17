package 考研.线性表.线性表示.ArrayList;

import org.junit.Test;
import 考研.utils.MyUtil;

import java.util.ArrayList;

public class Qs {


    /**
     * P19 7 将两个有序表合为一个新的有序表，返回结果表
     */
    public ArrayList<Integer> q7(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (list1 == null || list1.size() == 0) return list2;
        if (list2 == null || list2.size() == 0) return list1;

        ArrayList<Integer> res = new ArrayList<Integer>();
        int size1 = list1.size();
        int size2 = list2.size();

        int index1 = 0;
        int index2 = 0;
        while (index1 < size1 || index2 < size2) {
            if (index1 == size1) {
                for (int i = index2; i < size2; i++) {
                    res.add(list2.get(i));
                }
                return res;
            } else if (index2 == size2) {
                for (int i = index1; i < size1; i++) {
                    res.add(list1.get(i));
                }
                return res;
            }
            int val1 = list1.get(index1);
            int val2 = list2.get(index2);
            if (val1 < val2) {
                res.add(val1);
                index1++;
            } else {
                res.add(val2);
                index2++;
            }
        }
        return res;

    }

    @Test
    public void test7() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list1.add(i);
        }
        list1.add(8);
        list1.add(9);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 3; i < 5; i++) {
            list2.add(i);
        }

        list2.add(10);
        ArrayList<Integer> res = q7(list1, list2);
        System.out.println(res);
    }


    /**
     * P19 8  不会。
     */
    public void q8(int[] arr, int m, int n) {


        //先把整个数组逆序
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        //再分别对两部分逆序
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        for (int i = n; i < (m / 2 + n); i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1 + n];
            arr[arr.length - i - 1 + n] = temp;

        }

    }

    @Test
    public void test8() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        q8(arr, 2, 4);
        MyUtil.printArr(arr);
    }


    /**
     * P20 9 找到数值为x的元素
     * - 如果找到，将其与后继元素交换位置
     * - 如果找不到，插入其中，保持顺序
     */
    public int[] q9(int[] arr, int x) {
        if (arr == null || arr.length == 0) return new int[]{x};
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x && (i + 1) < arr.length)  {
                MyUtil.swap(arr,i,i+1);
                return arr;
            }else if (arr[i]>x){
                index=i;
                break;
            }
        }
        System.arraycopy(arr,index,arr,index+1,arr.length-index-1);
        arr[index]=x;
        return arr;
    }

    @Test
    public void test(){
        int[] arr=new int[10];
        for (int i = 0; i < 3; i++) {
            arr[i]=i+1;
        }
        for (int i = 3; i < 5; i++) {
            arr[i]=i+2;
        }
        q9(arr,4);
        MyUtil.printArr(arr);
    }



}

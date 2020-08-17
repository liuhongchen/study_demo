package 考研.线性表.线性表示.ArrayList;

import org.junit.Test;

public class MyArrayList2_2 extends MyArrayList {

    MyArrayList2_2 list;


    public void init() {
        list = new MyArrayList2_2();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }

    public Integer findMinIndex() {
        int min = (int) arr[0];
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (((int) arr[i]) < min) {
                min = (int) arr[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * P19 1
     *
     * @return
     */
    public Integer deleteMin() {
        Integer index = findMinIndex();
        Integer min = (int) arr[index];

        arr[index] = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return min;
    }


    /**
     * P19 2 将顺序表所有元素逆置，要求算法的空间复杂度为1
     */
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
    }

    /**
     * P19 3 删除线性表中所有值为x的数据元素
     */
    public void deleteTarget1(Integer x) {//顺序copy
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(x)) {
                System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                arr[size - 1] = null;
                size--;
            }
        }
    }

    public void deleteTarget2(Integer x) {//直接后面替换
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(x)) {

                arr[i] = arr[size - 1];
                arr[size - 1] = null;
                size--;
                i--;

            }
        }
    }

    @Test
    public void test3() {
        init();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(4);
        list.add(7);
        System.out.println(list);
        list.deleteTarget2(4);
        System.out.println(list);
    }


    /**
     * P19 4 从有序顺序表中删除值介于s和t之间的所有元素
     */
    public void deleteBetween2(Integer s, Integer t) {
        if (s > t || arr == null || size == 0) {
            System.out.println("error");
            return;
        }
        int num = 0;
        int first = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] >= s && arr[i] <= t) {
                if (first == -1) first = i;
                arr[i] = null;
                num++;
            } else if (arr[i] > t) {
                break;
            }
        }
        if (first != -1) {
            System.arraycopy(arr, first + num, arr, first, size - first - num);
            for (int i = first + num; i < size; i++) {
                arr[i] = null;
            }
            size -= num;
        }

    }

    @Test
    public void test4() {
        init();
        for (int i = 0; i < 4; i++) {
            list.add(i + 4);
        }
        System.out.println(list);
        list.deleteBetween(2, 5);
        System.out.println(list);
    }

    /**
     * P19 5 从无序顺序表中删除值介于s和t之间的所有元素
     */
    public void deleteBetween(Integer s, Integer t) {
        if (s > t || arr == null || size == 0) {
            System.out.println("error");
            return;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] >= s && arr[i] <= t) {
                arr[i] = arr[size - 1];
                arr[size - 1] = null;
                i--;
                size--;
            }
        }
    }

    @Test
    public void test5() {
        init();
        for (int i = 0; i < 4; i++) {
            list.add(i + 4);
        }
        System.out.println(list);
        list.deleteBetween2(2, 5);
        System.out.println(list);
    }

    /**
     * P19 6 从有序表中删除所有其值重复的元素，使表中所有元素的值均不同
     */
    public void q6() {
        int i=0;
        int j=1;
        while (j<size){
            if (arr[i].equals(arr[j])){
                arr[j]=null;
            }else{
                i=j;
            }
            j++;

        }

    }

    @Test
    public void test6() {
        init();
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(7);
        System.out.println(list);
        list.q6();
        System.out.println(list);
    }



}

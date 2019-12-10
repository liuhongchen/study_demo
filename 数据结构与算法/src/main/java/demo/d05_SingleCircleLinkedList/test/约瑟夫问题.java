package demo.d05_SingleCircleLinkedList.test;

import demo.d05_SingleCircleLinkedList.SingleCircleLinkedList;

/**
 * ClassName:约瑟夫问题
 * Package:demo.d05_SingleCircleLinkedList.test
 * Description:
 *
 * @date:2019-12-10 20:56
 * @author:892698613@qq.com
 */

public class 约瑟夫问题 {

    /**
     * 约瑟夫问题,一共有m个人,报n个数字为一轮,每一轮的第n个被杀掉
     * @param m
     * @param n
     * @return
     */
    public static int compute(int m,int n) {
        SingleCircleLinkedList list=new SingleCircleLinkedList();
        for(int i=m;i>0;i--){
            list.add(i);
        }

        int count=0;
        while (list.size>1){
            int x=list.size;
            for(int i=0;i<x;i++){
                count++;
                if (count==n){
                    list.remove(i);
                    i--;
                    count=0;
                }
            }
        }
        return Integer.parseInt(list.get(0).val.toString());



    }


    public static void main(String[] args) {
        System.out.println(compute(3,2));
    }
}

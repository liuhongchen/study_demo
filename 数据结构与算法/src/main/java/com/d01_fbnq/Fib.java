package com.d01_fbnq;

import org.junit.Test;

/**
 *            0  1 2,数列，索引是从0开始的
 * com.demo.斐波那契数列.d01_复杂度.斐波那契数列 0，1，1，2，3，5，8，13。。。
 */
//@Component
public class Fib  {


    /**
     * 递归实现,存在性能问题
     * @param n
     * @return
     */
    private int fib1(int n){
        if(n<=1) return n;

        return fib1(n-1)+fib1(n-2);
    }

    @Test
    public void test01(){
        System.out.println(fib1(0));
        System.out.println(fib1(1));
        System.out.println(fib1(2));
        System.out.println(fib1(3));
        System.out.println(fib1(4));
        System.out.println(fib1(5));
        System.out.println(fib1(10));

    }


    /**
     * 使用for循环来实现，根据规律判断总共循环的次数，也就是总共要加多少次。
     * 前面总共要加n-1次
     * @param n
     * @return
     */
    private int fib2(int n){
        if (n<=1)return n;

        int first=0;
        int second=1;

        for (int i=0;i<n-1;i++){
            int sum=first+second;
            first=second;
            second=sum;
        }

        return second;
    }


    @Test
    public void test02(){
        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(2));
        System.out.println(fib2(3));
        System.out.println(fib2(4));
        System.out.println(fib2(5));
        System.out.println(fib2(10));
    }




}


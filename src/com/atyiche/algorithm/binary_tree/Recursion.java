package com.atyiche.algorithm.binary_tree;

/**
 * @author liangyt
 * @create 2021-02-24 10:59
 */
//递归
public class Recursion {
    //定义一个计算阶乘的方法
    public static int factorial1(int n){
        if ( n == 0 ) return 1;
        return factorial1(n - 1) * n;
    }

    // 尾递归计算阶乘，需要多一个参数保存“计算状态”
    public static int factorial(int acc, int n){
        if ( n == 0 ) return acc;
        return factorial( acc * n,n - 1 );
    }


    public static void main(String[] args) {
        System.out.println(factorial(1, 6));
    }
}

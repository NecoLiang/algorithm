package com.atyiche.algorithm.dynamic_programming;

/**
 * @author liangyt
 * @create 2021-03-01 16:26
 */
//斐波那契数列
public class Fibonacci {
    // 方法一：递归
    public int fib1( int n ){
        if ( n == 1 || n == 2 ) return 1;
        return fib1(n-2) + fib1(n-1);
    }

    // 方法二：动态规划
    public int fib2(int n){
        if ( n == 1 || n == 2 ) return 1;
        // 定义一个dp数组，用来保存fib(i)的计算结果
        int[] dp = new int[n];
        dp[0] = dp[1] = 1;
        // 从3开始，依次计算fib(i)
        for ( int i = 2; i < n; i++ ){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n-1];
    }

    //方法三：空间优化
    public int fib(int n){
        if ( n == 1 || n == 2 ) return 1;
        // 定义两个变量，分别保存之前两个状态
        int pre2 = 1, pre1 = 1;
        for ( int i = 2; i < n; i++ ){
            int curr = pre2 + pre1;
            pre2 = pre1;
            pre1 = curr;
        }
        return pre1;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(9));
    }
}

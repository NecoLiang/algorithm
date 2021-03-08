package com.atyiche.algorithm.dynamic_programming;

/**
 * @author liangyt
 * @create 2021-03-08 18:01
 */
public class ClimbingStairs {
    // 动态规划
    public int climbStairs1(int n) {
        int[] dp = new int[n+1];
        // 初始状态
        dp[0] = 1;
        dp[1] = 1;
        // 遍历所有状态，逐级计算
        for ( int i = 2; i <= n; i++ ){
            dp[i] = dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
    //数学公式法
    public int climbStairs(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib = ( Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1) ) / sqrt_5;
        return (int) fib;
    }

    public static void main(String[] args) {
        int n = 3;
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(n));
    }
}

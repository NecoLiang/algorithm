package com.atyiche.algorithm.dynamic_programming;

/**
 * @author liangyt
 * @create 2021-03-01 18:13
 */
public class KnapsackProblem {
    public int maxValue1(int capacity, int[] weights, int[] values ){
        int n = weights.length;
        int[][] dp = new int[n+1][capacity+1];
        // 遍历所有可能的物品个数和背包容量
        for ( int i = 1; i <= n; i++ ){
            for ( int j = 0; j <= capacity; j++ ){
                if ( j >= weights[i-1] ){
                    dp[i][j] = Math.max( dp[i-1][j], dp[i-1][j-weights[i-1]] + values[i-1] );
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
    }
    // 空间优化
    public int maxValue(int capacity, int[] weights, int[] values ) {
        int n = weights.length;
        // 设置一维矩阵保存状态
        int[] dp = new int[capacity+1];
        for ( int i = 1; i <= n; i++ ){
            for ( int j = capacity; j > 0; j-- ){
                if ( j >= weights[i-1] ){
                    dp[j] = Math.max( dp[j], dp[j-weights[i-1]] + values[i-1] );
                }
            }
        }
        return dp[capacity];
    }


    public static void main(String[] args) {
        int W = 150;
        int[] w = {35  , 30  , 60  , 50  , 40  , 10  , 25};
        int[] v = {10  , 40  , 30  , 50  , 35  ,  40  , 30};
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        System.out.println(knapsackProblem.maxValue(W,w,v));
    }
}

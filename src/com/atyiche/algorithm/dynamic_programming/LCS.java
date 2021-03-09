package com.atyiche.algorithm.dynamic_programming;

/**
 * @author liangyt
 * @create 2021-03-08 19:28
 */
public class LCS {
    // 动态规划实现
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1+1][length2+1];
        // 遍历所有状态位置
        for (int i = 1; i <= length1; i++){
            for (int j = 1; j <= length2; j++){
                // 状态转移
                if ( text1.charAt(i-1) == text2.charAt(j-1) ){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String text1="abcde";
        String text2="abc";
        LCS lcs = new LCS();
        System.out.println(lcs.longestCommonSubsequence(text1,text2));
    }
}

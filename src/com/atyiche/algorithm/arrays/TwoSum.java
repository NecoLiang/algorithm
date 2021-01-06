package com.atyiche.algorithm.arrays;

/**
 * @author liangyt
 * @create 2021-01-06 16:50
 */
//两数之和
public class TwoSum {
    //方法一：暴力法，穷举所有两数之和
    public int[] twoSum(int[] nums,int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }
        //找不到抛出异常
        throw new IllegalArgumentException("no solution");
    }

    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int target = 22;
        TwoSum twoSum = new TwoSum();
        int[] output = twoSum.twoSum(input, target);
        for (int index : output) {
            System.out.print(index+"\t");
        }
    }
}

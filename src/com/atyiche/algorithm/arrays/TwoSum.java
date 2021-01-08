package com.atyiche.algorithm.arrays;

import java.util.HashMap;

/**
 * @author liangyt
 * @create 2021-01-06 16:50
 */
//两数之和
public class TwoSum {
    //方法一：暴力法，穷举所有两数之和(排列组合n中取2)
    public int[] twoSum1(int[] nums,int target) {
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

    //方法2：哈希表保存所有数的信息(空间换时间)
    public int[] twoSum2(int[] nums,int target) {
        int n = nums.length;
        //定义一个哈希表
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //所有请求数据存入哈希表
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i],i);
        }
        //遍历请求数据，找对应目标数据
        for (int i = 0; i <n; i++) {
            int thatNum = target - nums[i];
            if (hashMap.containsKey(thatNum) && hashMap.get(thatNum)!=nums[i]){
                return new int[]{i,hashMap.get(thatNum)};
            }
        }
            //找不到抛出异常
            throw new IllegalArgumentException("no solution");
    }

    //方法3：单次for循环，向前查找
    public int[] twoSum(int[] nums,int target) {
        int n = nums.length;
        //定义一个哈希表
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //遍历请求数据，找对应目标数据(一边验一边存)
        for (int i = 0; i <n; i++) {
            int thatNum = target - nums[i];
            if (hashMap.containsKey(thatNum) && hashMap.get(thatNum)!=nums[i]){
                return new int[]{hashMap.get(thatNum),i};
            }
            hashMap.put(nums[i],i);
        }
        //找不到抛出异常
        throw new IllegalArgumentException("no solution");
    }
    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        int target = 22;
        long startTime = System.currentTimeMillis();
        TwoSum twoSum = new TwoSum();
        int[] output = twoSum.twoSum1(input, target);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        for (int index : output) {
            System.out.print(index+"\t");
        }
    }
}

package com.atyiche.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author liangyt
 * @create 2021-01-08 15:27
 */
public class ThreeSum {
    //方法一：暴力法（有重复解）
    public List<List<Integer>> threeSum1(int[] nums){
        int n = nums.length;
        //定义结果列表
        ArrayList<List<Integer>> result = new ArrayList<>();
        //三重for循环，枚举所有的三数组合
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
            return result;
    }

    //方法二：哈希表存储法
    public List<List<Integer>> threeSum2(int[] nums){
        int n = nums.length;
        ArrayList<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        //遍历数组，寻找元素的thatNum
        for (int i = 0; i < n; i++) {
            int thatNum = 0 - nums[i];
            if (hashMap.containsKey(thatNum)) {
                ArrayList<Integer> tempList = new ArrayList<>(hashMap.get(thatNum));
                tempList.add(nums[i]);
                result.add(tempList);
                continue;
            }
            for (int j = 0; j < i; j++) {
               int newKey = nums[i] + nums[j];
               if (!hashMap.containsKey(newKey)){
                   ArrayList<Integer> tempList = new ArrayList<>();
                   tempList.add(nums[j]);
                   tempList.add(nums[i]);
                   hashMap.put(newKey,tempList);
               }
            }
        }
        return result;
    }

    //双指针法
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        ArrayList<List<Integer>> result = new ArrayList<>();
        //对数组进行排序
        Arrays.sort(nums);
        //遍历元素，数组中最小的为核心（最矮个核心）
        for (int i = 0; i < n; i++) {
            //当前数大于0，直接退出循环
            if (nums[i]>0)
                break;
            //当前数重复出现，跳过该数循环
            if (i>0 && nums[i] == nums[i-1])
                continue;
            //常规情况，当前数为核心，定义左右指针
            int lp = i + 1;
            int rp = n - 1;
            //左右指针不重叠就继续移动指针
            while (lp<rp){
                int sum = nums[i]+nums[lp]+nums[rp];
                //判断结果与目标
                if (sum == 0){
                    result.add(Arrays.asList(nums[i],nums[lp],nums[rp]));
                    lp++;
                    rp--;
                    //移动后元素相同直接跳过
                    while (lp<rp && nums[lp] == nums[lp-1])lp++;
                    while (lp<rp && nums[rp] == nums[rp+1])rp--;
                }else if (sum<0){
                    //小于0，左指针右移
                    lp++;
                }else {
                    //大于0，右指针左移
                    rp--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(input));
    }
}

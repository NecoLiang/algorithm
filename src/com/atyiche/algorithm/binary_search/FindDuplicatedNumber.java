package com.atyiche.algorithm.binary_search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author liangyt
 * @create 2021-01-13 15:00
 */
public class FindDuplicatedNumber {
    //方法一：HashMap保存每个数出现的个数
    public int findDuplicate1(int[] nums){
        HashMap<Object, Object> hashMap = new HashMap<>();
        //遍历所有元素统计count的值
        for (int num : nums){
            if(hashMap.containsKey(num))
                return num;
            else
                hashMap.put(num,1);
        }
        return -1;
    }

    //方法二：使用HashSet保存元素
    public int findDuplicate2(int[] nums){
        HashSet<Object> hashSet = new HashSet<>();
        //遍历所有元素统计count的值
        for (int num : nums){
            if(hashSet.contains(num))
                return num;
            else
                hashSet.add(num);
        }
        return -1;
    }

    //方法三：排序，找相同的相邻元素
    public int findDuplicate3(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1])
                return nums[i];
        }
        return -1;
    }

    //方法四：二分查找，查找1~N的自然数序列，寻找target
    public int findDuplicate4(int[] nums){
        //定义左右指针
        int left = 1;
        int right = nums.length - 1;
        while (left < right){
            int mid = (left + right)/2;
            //对当前mid计算count值
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid){
                    count++;
                }
            }
            // 判断count[i]和i的大小关系
            if (count <= mid){
                left = mid + 1;//count小于等于mid自身，说明mid比target小，左指针右移
            }else {
                right = mid;
            }
            //左右指针重合时，找到target
            if (left == right)
                return left;
        }
        return -1;
    }

    //方法五：快慢指针
    public int findDuplicate(int[] nums){
        //定义快慢指针
        int fast = 0;
        int slow = 0;
        //寻找环内相遇的点
        do {
            //快指针一次走两步，慢指针一次走一步
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (fast != slow);
        //循环结束，slow和fast相等，都是相遇点
        //寻找环的入口
        //另外定义两个指针，固定间距
        int before = 0 , after = slow;
        while (before != after){
            before = nums[before];
            after = nums[after];
        }
        //循环结束，相遇点就是环入口，重复元素
        return before;
    }
    public static void main(String[] args) {
        //1+N个数，数组元素必须在1-N之间
        int[] nums1 = {1,2,4,3,4};
        int[] nums2 = {1,1,1};
        FindDuplicatedNumber findDuplicatedNumber = new FindDuplicatedNumber();
        System.out.println(findDuplicatedNumber.findDuplicate(nums1));
        System.out.println(findDuplicatedNumber.findDuplicate(nums2));

    }
}

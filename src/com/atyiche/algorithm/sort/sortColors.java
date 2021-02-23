package com.atyiche.algorithm.sort;

import java.util.Arrays;

/**
 * @author liangyt
 * @create 2021-02-23 16:23
 */
public class sortColors {
    //方法一：内置培训
    public void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }
    //方法二：基于选择排序
    public void sortColors2(int[] nums) {
        //定义一个指针，指向当前应该填入元素的位置
        int curr = 0;
        // 第一次遍历，将扫描到的0交换到数组头部
        for ( int i = 0; i < nums.length; i++){
            if ( nums[i] == 0 ){
                KthLargestElement.swap(nums, curr++, i);
            }
        }
        // 第二次遍历，将扫描到的1跟在后面
        for ( int i = 0; i < nums.length; i++){
            if ( nums[i] == 1 ){
                KthLargestElement.swap( nums, curr++, i );
            }
        }
    }
    //方法三：基于计数排列
    public void sortColors3(int[] nums) {
        int count0 = 0, count1 = 0;
        // 遍历数组，统计0，1，2的个数
        for ( int num: nums ){
            if ( num == 0 )
                count0 ++;
            else if ( num == 1 )
                count1 ++;
        }
        // 将0，1，2按个数依次填入数组
        for ( int i = 0; i < nums.length; i++ ){
            if ( i < count0 )
                nums[i] = 0;
            else if ( i < count0 + count1 )
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }
    //方法四：基于快排
    public void sortColors(int[] nums) {
        //定义左右指针
        int left = 0, right = nums.length - 1;
        //定义一个遍历所有元素的指针
        int i = left;
        //循环判断，遍历元素
        while ( left < right && i <= right ){
            while ( i <= right && nums[i] == 2 )
                KthLargestElement.swap( nums, i, right-- );
            if ( nums[i] == 0 )
                KthLargestElement.swap( nums, i, left++ );
            i++;
        }

    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors sortColors = new sortColors();
        sortColors.sortColors(nums);
        QuickSort.printArray(nums);
    }
}

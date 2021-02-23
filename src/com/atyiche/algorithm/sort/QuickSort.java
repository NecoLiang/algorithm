package com.atyiche.algorithm.sort;

/**
 * @author liangyt
 * @create 2021-02-23 11:35
 */
public class QuickSort {
    public static void qSort( int[] nums, int start, int end ){
        //基准情况
        if ( start >= end )return;
        //1.找到一个pivot,把数组分成两部分，返回pivot索引位置
        int mid = partition(nums, start, end);
        //递归排序左右两部分
        qSort( nums, start, mid - 1 );
        qSort( nums, mid + 1, end );

    }
    // 定义一个分区方法
    private static int partition( int[] nums, int start, int end ){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while ( left < right ){
            //左移右指针，找到一个比pivot小的数，填入空位
            while ( left < right && nums[right] >= pivot )
                right --;
            nums[left] = nums[right];
            while ( left < right && nums[left] <= pivot )
                left ++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int nums[] = {45,6,32,5,7,34,23,56};
        qSort(nums,0,nums.length-1);
        printArray(nums);
    }
    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}

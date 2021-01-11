package com.atyiche.algorithm.arrays;


import java.util.Arrays;

/**
 * @author liangyt
 * @create 2021-01-11 11:04
 */
public class NextPermutation {
    //思路：从后向前找到升序子序列，确定调整后子序列的最高位，剩余部分升序排列
    public void nextpermutation1(int[] nums){
        int n = nums.length;
        //1.从后向前找到升序子序列，找到第一次下降的数，位置记为K
        int k = n - 2;
        while (k>0 && nums[k]>=nums[k+1])
            k--;
        //找到k，就是需要调整的部分的最高位

        //2.如果k = -1，说明所有数降序排列改为升序排列
        if (k==-1){
            Arrays.sort(nums);
            return;
        }
        //3.一般情况，k>=0
        //3.1依次遍历剩余降序排列的部分，找到要替换的最高位的数
        int i = k+2;
        while (i<n && nums[i]>nums[k])
            i++;
        //当前的i，就是后面降序队列部分第一个比nums[k]小的数，i-1就是要替换的那个数
        //3.2 交换i-1和k位置上的数
        int temp = nums[k];
        nums[k] = nums[i-1];
        nums[i-1] = temp;
        //3.3 k之后的剩余部分变为升序排列，前后进行交换
        int start = k+1;
        int end = n-1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    //方法改进，提取降序数组的反转
    public void nextpermutation(int[] nums) {
        int n = nums.length;
        //1.从后向前找到升序子序列，找到第一次下降的数，位置记为K
        int k = n - 2;
        while (k>0 && nums[k]>=nums[k+1])
            k--;
        //找到k，就是需要调整的部分的最高位

        //2.如果k = -1，说明所有数降序排列改为升序排列
        if (k==-1){
            reverse(nums,0,n-1);
            return;
        }

        //3.一般情况，k>=0
        //3.1依次遍历剩余降序排列的部分，找到要替换的最高位的数
        int i = k+2;
        while (i<n && nums[i]>nums[k])
            i++;
        //当前的i，就是后面降序队列部分第一个比nums[k]小的数，i-1就是要替换的那个数

        //3.2 交换i-1和k位置上的数
        swap(nums,k,i-1);

        //3.3 k之后的剩余部分变为升序排列，前后进行交换
        reverse(nums,k+1,n-1);
    }
    //定义一个方法，交换数组中的两个元素
    private void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //定义一个翻转数组的方法
    private void reverse(int[] nums,int start ,int end){
        while (start < end) {
           swap(nums,start,end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextpermutation(nums);
        for (int num : nums) {
            System.out.print(num+"\t");
        }

    }
}

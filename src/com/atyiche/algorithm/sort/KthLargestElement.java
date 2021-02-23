package com.atyiche.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liangyt
 * @create 2021-02-23 15:02
 */
public class KthLargestElement {
    // 直接调语言内置的排序方法
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //方法二：基于快排的选择
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect( nums, 0, nums.length - 1, nums.length - k );
    }

    //方法三：基于堆排序的选择
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int heapSize = n;
        // 构建大顶堆
        buildMaxHeap( nums, heapSize );
        // 删除k-1次堆顶元素
        for ( int i = n - 1; i > n - k; i-- ){
            //将堆顶元素交换到当前堆的末尾
            swap( nums, 0, i );
            heapSize --;
            maxHeapify( nums, 0, heapSize );
        }
        return nums[0];

    }
    // 构建大顶堆的方法
    public void buildMaxHeap( int[] nums, int heapSize ){
        for ( int i = heapSize / 2 - 1; i >= 0; i-- ){
            maxHeapify(nums, i, heapSize);
        }
    }

    //定义一个调整成大顶堆的方法
    public void maxHeapify( int[] nums, int top, int heapSize ) {
        int left = top * 2 + 1;
        int right = top * 2 + 2;
        int largest = top;
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (largest != top) {
            swap(nums, top, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }
        // 为了方便递归，定义一个快速选择方法
    public int quickSelect( int[] nums, int start, int end, int index ){
        //找到pivot的位置返回
        int q = randomPatition( nums, start, end );
        //判断当前pivot的位置是否为index
        if (q == index){
            return nums[q];
        } else {
            return q > index ? quickSelect(nums, start, q - 1, index) : quickSelect(nums, q + 1, end, index);
        }

    }
    // 定义一个随机分区方法
    public int randomPatition( int[] nums, int start, int end ){
        Random random = new Random();
        int randIndex = start + random.nextInt(end - start + 1);
        swap(nums, start, randIndex);
        return partition(nums, start, end);
    }
    // 定义一个交换元素的方法
    public static void swap( int[] nums, int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 定义一个分区方法
    public int partition( int[] nums, int start, int end ){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while ( left < right ){
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
        int[] nums1 = {3,2,1,5,6,4};
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargest(nums1,2));
        System.out.println(kthLargestElement.findKthLargest(nums2,4));

    }
}

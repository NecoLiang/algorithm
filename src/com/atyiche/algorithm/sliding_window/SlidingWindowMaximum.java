package com.atyiche.algorithm.sliding_window;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liangyt
 * @create 2021-01-19 15:42
 */
//滑动窗口最大值
public class SlidingWindowMaximum {
    //方法一：暴力法，遍历每一个窗口，对每个窗口遍历每个元素求最大值
    public int[] maxSlidingWindow1(int[] nums, int k) {
        //定义一个结果数组，总共有n-k+1个窗口
        int[] result = new int[nums.length - k + 1];
        //遍历数组，从0到n-k，作为滑动窗口的起始位置
        for (int i = 0; i <= nums.length - k; i++) {
            //找窗口内的最大值，定义一个变量来保存
            int max = nums[i];
            //遍历窗口中的每一个元素比较大小
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max){
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    //方法二：使用大顶堆
    public int[] maxSlidingWindow2(int[] nums, int k) {
        //定义一个结果数组
        int[] result = new int[nums.length - k + 1];
        //用优先队列实现一个大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o2 - o1;
            }
        });
        //准备工作：构建大顶堆，将第一个窗口元素（k个）放入堆中
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        //当前大顶堆的顶堆元素就是第一个窗口的最大值
        result[0] = maxHeap.peek();
        //遍历所有窗口
        for (int i = 1; i <= nums.length - k; i++) {
            //删除上一个窗口中的元素
            maxHeap.remove(nums[i -1]);
            //添加当前的最后一个元素进堆
            maxHeap.add(nums[i + k -1]);
            result[i] = maxHeap.peek();
        }
        return result;
    }

    //方法三：使用双向队列
    public int[] maxSlidingWindow3(int[] nums, int k) {
        //定义一个结果数组
        int[] result = new int[nums.length - k + 1];
        //定义双向队列,保存元素的索引
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        //初始化双向队列，处理第一个窗口数据
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.removeLast();
            deque.addLast(i);
        }
        result[0] = nums[deque.getFirst()];//第一个窗口的最大值
        //遍历数组中的所有元素,作为窗口的起始位置
        for (int i = k; i < nums.length; i++) {
           //如果上一个窗口删掉的就是窗口最大值，那么需要将队列中的最大值删掉
            if (!deque.isEmpty() && deque.getFirst() == i - k)
                deque.removeFirst();
            //判断新增元素是否可以删除队尾元素
            //如果队尾元素小于当前元素，直接删除
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()])
                deque.removeLast();
            deque.addLast(i);
            //保存结果
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }

    //方法四：左右扫描
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //定义一个结果数组
        int[] result = new int[n - k + 1];
        //定义存放块内最大值的left和right数组
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            //1.从左到右
            if (i % k == 0){
                //如果能整除k，就是块的起始位置
                left[i] = nums[i];
            }else {
                left[i] = Math.max(left[i-1], nums[i]);
            }
            //2.从右到左
            int j = n - i -1; //j就是倒数的i
            if (j % k == k - 1 || j == n - 1 ){
                right[j] = nums[j];
            }else{
                right[j] = Math.max(right[j+1], nums[j]);
            }
        }
            //对每个窗口计算最大值
            for (int l = 0; l < n - k + 1; l++) {
                result[l] = Math.max(right[l],left[l + k - 1]);
            }
        return result;
    }
    public static void main(String[] args) {
        int[] input = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] output = slidingWindowMaximum.maxSlidingWindow(input,k);
        for (int max : output) {
            System.out.print(max + "\t");
        }
    }
}

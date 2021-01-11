package com.atyiche.algorithm.arrays.binary_search;

/**
 * @author liangyt
 * @create 2021-01-11 17:34
 */
public class BinarySearch {
    public static int binarySearch(int[] a ,int key){
        //定义初始查找范围
        int low = 0;
        int high = a.length -1;
        //排除特殊情况
        if (key < a[low] || key > a[high])
            return -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (a[mid] < key)
                low = mid +1;
            else if (a[mid] > key)
                high = mid -1;
            else
                return mid;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int key = 7;
        int index = binarySearch(arr, key);
        System.out.print(index);
    }
}

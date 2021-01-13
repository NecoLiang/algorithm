package com.atyiche.algorithm.arrays.binary_search;

/**
 * @author liangyt
 * @create 2021-01-13 13:57
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix,int target){
        //先定义m，n
        int m = matrix.length;
        if (m == 0)return false;
        int n = matrix[0].length;

        //二分查找定义左右指针
        int left = 0;
        int right = m*n - 1;

        while (left <= right){
            //计算中间位置
            int mid = (left + right)/2;
            //计算二维矩阵中对应的行列号，取出对应的元素(row = idx / n; col = idx % n; idx = row * n + col)
            int midElement = matrix[mid/n][mid%n];
            if (midElement < target){
                left = mid + 1;
            }else if (midElement > target){
                right = mid - 1;
            }else {
                return true;
            }
        }
            return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix,target));
    }
}

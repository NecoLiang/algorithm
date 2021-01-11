package com.atyiche.algorithm.arrays;

import java.awt.*;

/**
 * @author liangyt
 * @create 2021-01-11 15:14
 */
public class RotateImage {
    //方法1：数学方法（矩阵转置，翻转每一行）
    public void rotate1(int[][] matrix){
        int n = matrix.length;
    //转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
               int temp = matrix[i][j];
               matrix[j][i] = matrix[i][n-j-1];
               matrix[i][n-j-1] = temp;
            }
        }
    }

    //方法二：分治思想，分为四个子矩阵分别考虑
    public void rotate2(int[][] matrix){
        int n = matrix.length;
        //遍历四分之一矩阵，左上角
        for (int i = 0; i < n/2 + n%2; i++) {
            for (int j = 0; j < n/2; j++) {
            //对于matrix[i][j]，需要找到四个不同的矩阵中对的另外三个位置和元素、
                //定义一个临时数组，保存对应的四个元素
                int[] temp = new int[4];
                int row = i;
                int col = j;
                //行列转换的规律， row + newCol = n - 1 , col = newRow
                for (int k = 0; k < 4; k++) {
                    temp[k] = matrix[i][j];
                    int x = row;
                    row = col;
                    col = n - 1 -x;
                }
                //再次遍历要处理的四个位置，将旋转后的数据填入
                for (int k = 0; k < 4; k++){
                    //用上一个值替换当前的位置
                    matrix[row][col] = temp[(k+3)%4];
                    int x = row;
                    row = col;
                    col = n - 1 -x;
                }
            }
        }
    }

    //方法三：分治法改进（单次循环内完成旋转）
    public void rotate(int[][] matrix){
        int n = matrix.length;
        // 不区分子矩阵，直接遍历每一个元素
        for( int i = 0; i < (n + 1)/2; i++ ){
            for( int j = 0; j < n/2; j++ ) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] image1 ={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] image2 = {
                { 1, 2, 3, 4},
                { 5, 7, 6, 8},
                {11,34,21,12},
                {33,12, 4, 6}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(image1);
        rotateImage.printImage(image1);
        rotateImage.rotate(image2);
        rotateImage.printImage(image2);
    }
    private void printImage(int[][] image){
        System.out.println("image:");
        for (int[] line : image) {
            for (int point : line) {
                System.out.print(point+"\t");
            }
            System.out.println();
        }
    }
}

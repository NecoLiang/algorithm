package com.atyiche.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liangyt
 * @create 2021-02-23 18:17
 */
public class MergeIntervals {
    //按区间左边界排序
    public int[][] merge(int[][] intervals) {
        //定义一个结果数组
        List<int[]> result = new ArrayList<int[]>();
        //将所有区间按照左边界排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //2.遍历排序后的区间，逐个合并
        for (int[] interval : intervals) {
            //记录当前左右边界
            int left = interval[0], right = interval[1];
            //获取结果数组的长度
            int length = result.size();
            if ( length == 0 || left > result.get(length - 1)[1] ){
                result.add(interval);
            } else {
                int mergedLeft = result.get(length - 1)[0];
                int mergedRight = Math.max( result.get(length - 1)[1], right );
                result.set( length - 1, new int[]{mergedLeft, mergedRight} );
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] merge = mergeIntervals.merge(intervals);
        for (int[] interval : merge) {
            QuickSort.printArray(interval);
        }
    }
}




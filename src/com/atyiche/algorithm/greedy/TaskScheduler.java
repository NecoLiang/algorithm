package com.atyiche.algorithm.greedy;

import java.util.*;

/**
 * @author liangyt
 * @create 2021-03-01 14:25
 */
public class TaskScheduler {
    // 方法一：模拟法
    public int leastInterval1(char[] tasks, int n) {
        //用HashMap统计每个任务出现的次数
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }
        //任务种类的数量
        int t = countMap.size();

        // 定义两个状态List
        //任务剩余次数
        List<Integer> restCount = new ArrayList<Integer>(countMap.values());
        //任务下一次的执行时间
        List<Integer> nextAvailableTime = new ArrayList<Integer>(Collections.nCopies(t, 1));

        int time = 0;

        // 遍历任务，循环执行
        for (int i = 0; i < tasks.length; i++) {
            time ++;
            // 获取所有任务中，最早可执行的时间
            int minNextAvailableTime = Integer.MAX_VALUE;
            for (int j = 0; j < t; ++j) {
                if (restCount.get(j) != 0) {
                    minNextAvailableTime = Math.min(minNextAvailableTime, nextAvailableTime.get(j));
                }
            }
            time = Math.max(time, minNextAvailableTime);
            // 选取所有可执行任务中，剩余次数最多的那个
            int maxRestTask = -1;
            for (int j = 0; j < t; ++j) {
                if (restCount.get(j) > 0 && nextAvailableTime.get(j) <= time) {
                    if (maxRestTask == -1 || restCount.get(j) > restCount.get(maxRestTask)) {
                        maxRestTask = j;
                    }
                }
            }
            // 更新两个状态列表
            nextAvailableTime.set(maxRestTask, time + n + 1);
            restCount.set(maxRestTask, restCount.get(maxRestTask) - 1);
        }
        return time;
    }

    // 方法二：构造法
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }
        //任务种类个数
        int t = countMap.size();
        int maxCount = 0;
        int maxNum = 0;
        // 计算maxCount
        for ( int count: countMap.values() ){
            maxCount = Math.max( maxCount, count );
        }
        // 计算maxNum
        for ( char task: countMap.keySet() ){
            if ( countMap.get(task) == maxCount )
                maxNum ++;
        }
        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxNum);

    }

        public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(tasks,2));
    }
}

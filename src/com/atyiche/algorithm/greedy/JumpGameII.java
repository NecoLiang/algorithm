package com.atyiche.algorithm.greedy;

/**
 * @author liangyt
 * @create 2021-02-25 18:28
 */
public class JumpGameII {
    // 方法一：反向跳跃
    public int jump1(int[] nums) {
        //定义一个变量保存跳跃步数
        int steps = 0;
        //定义循环变量
        int curPosition = nums.length - 1;
        //不停的向前跳跃，以得到最远的距离
        while (curPosition > 0) {
            //从前到后遍历数组元素，找到当前距离最远的“上一步位置”
            for (int i = 0; i < curPosition; i++) {
                if (i + nums[i] >= curPosition) {
                    curPosition = i;    //从前到后，第一次能跳到当前位置的位置，就是最远的上一步位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    // 方法二：正向跳跃，考虑两步的最远跳跃
    public int jump(int[] nums) {
        int steps = 0;
        // 定义双指针
        int farthest = 0;
        int nextFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextFarthest = Math.max(nextFarthest, i + nums[i]);
            if (i == farthest) {
                farthest = nextFarthest;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGameII jumpGameII = new JumpGameII();
        int jump = jumpGameII.jump(nums);
        System.out.println(jump);
    }
}

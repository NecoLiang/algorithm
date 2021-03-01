package com.atyiche.algorithm.greedy;

/**
 * @author liangyt
 * @create 2021-02-25 16:54
 */
public class JumpGame {
    // 贪心策略：维护当前能到的最远位置
    public boolean canJump(int[] nums) {
        int farthest = 0;
        // 遍历数组，更新farthest
        for (int i = 0; i < nums.length; i++ ){
            if (i <= farthest){
                farthest = Math.max(farthest, i + nums[i]);
                if (farthest >= nums.length - 1)
                    return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(jumpGame.canJump(nums1));
        System.out.println(jumpGame.canJump(nums2));
    }
}

package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week2;

import java.util.Arrays;

public class HouseRobber1 {
    public static void main(String[] args) {
        System.out.println(new HouseRobber1().rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robUtil(nums, 0, nums.length - 2), robUtil(nums, 1, nums.length - 1));
    }

    public int robUtil(int[] nums, int low, int high) {

        int prev1 = 0;
        int prev2 = 0;

        for (int i = low; i <= high; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }

        return prev1;
    }


}

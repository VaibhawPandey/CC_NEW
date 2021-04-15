package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week3;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        if (k == 0)
            return;

        nums = reverse(nums, 0, nums.length - 1);
        nums = reverse(nums, 0, k - 1);
        nums = reverse(nums, k, nums.length);

        return;
    }

    private int[] reverse(int[] nums, int st, int end) {
        while (st < end) {
            int temp = nums[st];
            nums[st] = nums[end];
            nums[end] = temp;
            st++; end--;
        }

        return nums;
    }
}

package main.java.Leetcode.WeeklyContest.WC218;

import java.util.Arrays;

public class MaxKPairSum {
    public static void main(String[] args) {
        new MaxKPairSum().maxOperations(new int[]{1, 2, 3, 4}, 5);
    }
    public int maxOperations(int[] nums, int k) {

        int n = nums.length;
        if (n == 1)
            return 0;

        Arrays.sort(nums);
        int res = 0;

        int i = 0, j = n-1;
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp == k) {
                res++;
                i++; j--;
            } else if (temp < k)
                i++;
            else
                j--;
        }

        return res;
    }
}

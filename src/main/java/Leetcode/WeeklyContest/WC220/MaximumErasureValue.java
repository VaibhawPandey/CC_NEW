package main.java.Leetcode.WeeklyContest.WC220;

import java.util.Arrays;

public class MaximumErasureValue {
    public static void main(String[] args) {
        System.out.println(new MaximumErasureValue().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
    public int maximumUniqueSubarray(int[] nums) {

        int sum[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        int lastIndex[] = new int[100001];
        int startIdx = 1;
        int res = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            if (lastIndex[nums[i - 1]] != 0 && lastIndex[nums[i - 1]] >= startIdx) {
                res = Math.max(res, sum[i - 1] - sum[startIdx - 1]);
                startIdx = lastIndex[nums[i - 1]] + 1;
            }

            lastIndex[nums[i - 1]] = i;
        }

        res = Math.max(res, sum[nums.length] - sum[startIdx - 1]);

        return res;
    }
}

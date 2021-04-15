package main.java.Leetcode.DP.Easy;

public class NumArray {

    int dp[];
    public NumArray(int[] nums) {
       dp = new int[nums.length + 1];
       dp[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            dp[i] = dp[i-1] + nums[i-1];

    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
}

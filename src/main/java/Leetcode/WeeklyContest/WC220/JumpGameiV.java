package main.java.Leetcode.WeeklyContest.WC220;

public class JumpGameiV {
    public static void main(String[] args) {

        System.out.println(new JumpGameiV().maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
    }

    // int res = Integer.MIN_VALUE;
    int dp[];
    public int maxResult(int[] nums, int k) {

        dp = new int[nums.length];
        return solve(nums, 0, k, nums[0]);
    }

    private int solve(int[] nums, int idx, int k, int sum) {

        if (dp[idx] != 0)
            return dp[idx];

        if (idx >= nums.length - 1) {
            System.out.println("Sum :- " + sum);
            // res = Math.max(res, sum);
            return sum;
        }

        for (int i = idx + 1; i <= idx + k && i < nums.length; i++)
            dp[idx] = Math.max(sum, solve(nums, i, k, sum + nums[i]));

        return dp[idx];
    }
}

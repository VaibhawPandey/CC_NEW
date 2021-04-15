package main.java.Leetcode.WeeklyContest.WC215;

public class MinOperation {
    public static void main(String[] args) {
        System.out.println(new MinOperation().minOperations(new int[]{3,2,20,1,1,3}, 10));
    }

    int dp[][];
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        if (x == 0)
            return 0;
        if (n == 0)
            return -1;

        boolean isAllGreater = true;
        int prefix[] = new int[n + 1];
        int suffix[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] <= x) {
                isAllGreater = false;
            }
            prefix[i+1] = prefix[i] + nums[i];
            suffix[n-i-1] = suffix[n-i] + nums[i];
        }


        if (isAllGreater)
            return -1;

        int i = 1;
        while (x > 0 && i <= n) {
            x -= prefix[i];
            i++;
        }

        if (x == 0)
            return i - 1;

        if (x > 0)
            return -1;

        int j = n - 1;
        i--;
        while (x < 0 && i > 0 && j > 0) {
            x += (prefix[i] - suffix[j]);
            i--; j--;
        }

        return x == 0 ? (i + j - 1): -1;

//        dp = new int[n][n];
//        int res = solve(nums, 0, n-1, 0, x);
//        return res == Integer.MAX_VALUE ? -1: res;
    }

    private int solve(int[] nums, int index, int n, int count, int x) {

        if (x == 0)
            return count;

        if (index > n || x < 0)
            return Integer.MAX_VALUE;

        if (dp[index][n] != 0)
            return dp[index][n];

        return dp[index][n] = Math.min(x > nums[index] ? solve(nums, index + 1, n, count + 1, x - nums[index]): Integer.MAX_VALUE,
                x > nums[n] ? solve(nums, index, n-1, count + 1, x - nums[n]): Integer.MAX_VALUE);
    }
}

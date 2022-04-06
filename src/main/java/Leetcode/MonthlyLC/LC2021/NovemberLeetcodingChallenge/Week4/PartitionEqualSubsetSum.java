package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week4;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5, 2}));
    }

    public boolean canPartition(int[] nums) {

        int sum = 0, n = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        if (sum % 2 == 1)
            return false;

        boolean dp[][] = new boolean[n + 1][(sum/2) + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (sum/2); j++) {

                if (j >= nums[i-1])
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];

                // System.out.print(j + "  " + dp[i][j] + " ");
            }
            // System.out.println();
        }



        return dp[n][sum/2];
    }

//    private boolean solve(int[] nums, int index, int n, int subsetSum1, int subsetSum2) {
//
//        if (subsetSum1 == subsetSum2 && index == n)
//            return true;
//
//        if (index >= n)
//            return false;
//
//        if (dp[index]) return dp[index];
//
//        return dp[index] = solve(nums, index + 1, n, subsetSum1 + nums[index], subsetSum2) ||
//                solve(nums, index + 1, n, subsetSum1, subsetSum2 + nums[index]);
//    }
}

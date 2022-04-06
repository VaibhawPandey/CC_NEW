package main.java.Leetcode.MonthlyLC.December21LC;

public class MinVal {
    public int minStartValue(int[] nums) {

        int minSum = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(minSum, sum);
        }

        if (minSum < 0) return Math.abs(minSum) + 1;
        else return 1;
    }
}

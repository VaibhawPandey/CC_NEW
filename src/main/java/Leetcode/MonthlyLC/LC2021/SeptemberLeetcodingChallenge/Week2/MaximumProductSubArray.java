package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week2;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {

        int max_ending_here = 1, min_ending_here = 1, max_so_far = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = max_ending_here;
                max_ending_here = min_ending_here;
                min_ending_here = temp;
            }

            max_ending_here = Math.max(max_ending_here * nums[i], nums[i]);
            min_ending_here = Math.min(min_ending_here * nums[i], nums[i]);

            max_so_far = Math.max(max_ending_here, max_so_far);

            if (nums[i] == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            }
        }


        return max_so_far;
    }
}

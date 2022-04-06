package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week5;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

        boolean available[] = new boolean[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                available[nums[i]] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!available[i])
                return i;
        }

        return -1;
    }
}

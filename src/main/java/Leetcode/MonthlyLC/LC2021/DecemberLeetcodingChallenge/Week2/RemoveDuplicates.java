package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week2;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        // int lastNumber = nums[0];
        int lastNumberCount = 1;
        int len = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i-1] == nums[i])
                lastNumberCount++;
            else {
                // lastNumber = nums[i];
                lastNumberCount = 1;
            }

            if (lastNumberCount <= 2) {
                nums[len] = nums[i];
                len++;
            }
        }

        return len;
    }
}

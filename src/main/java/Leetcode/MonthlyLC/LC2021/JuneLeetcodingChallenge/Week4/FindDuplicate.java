package main.java.Leetcode.MonthlyLC.LC2021.JuneLeetcodingChallenge.Week4;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int absI = Math.abs(nums[i]);
            if (nums[absI - 1] < 0)
                return Math.abs(nums[absI - 1]);

            nums[nums[i] - 1] *= -1;
        }

        return -1;
    }
}

package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week3;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {

        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) min = nums[i];
            else if (nums[i] < mid) mid = nums[i];
            else return true;
        }

        return false;
    }
    }

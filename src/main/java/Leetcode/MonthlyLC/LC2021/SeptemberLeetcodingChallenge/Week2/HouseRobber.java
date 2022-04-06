package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week2;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
    }

    public int rob(int[] nums) {

//        int prev1 = 0;
//        int prev2 = 0;
//
//
//        for (int i = 0; i < nums.length; i++) {
//            int temp = prev1;
//            prev1 = Math.max(prev2 + nums[i], prev1);
//            prev2 = temp;
//        }
//
//        return prev1;

        return recurse(nums, nums.length - 1, 0);
    }

    public int recurse (int nums[], int index, int sum) {
        if (index < 0)
            return sum;

        return Math.max(recurse(nums, index - 2, sum + nums[index]), recurse(nums, index - 1, sum));
    }

}

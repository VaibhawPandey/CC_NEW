package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week4;

public class SubArrayProduct {
    public static void main(String[] args) {

        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }


    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        int pro = 1, res = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];

            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            res += j - i + 1;
        }

        return res;
    }

}

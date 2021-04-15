package main.java.Leetcode.MonthlyLC.JulyLeetcodingChallenge.Week4;

public class MinimumInSortedArray {

    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            if (nums[left] > nums[mid])
                right = mid;
            else if (nums[right] < nums[mid])
                left = mid + 1;
            else
                right--;
        }

        return nums[left];
    }
}

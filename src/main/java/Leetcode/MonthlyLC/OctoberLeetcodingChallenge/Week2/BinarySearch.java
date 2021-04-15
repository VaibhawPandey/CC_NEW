package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week2;

public class BinarySearch {
    public int search(int[] nums, int target) {

        int start = 0, end = nums.length;

        while (start < end) {
            int mid = (start + end)/2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }

        return -1;
    }
}

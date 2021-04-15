package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week3;

public class SearchRotateArray {
    public static void main(String[] args) {
        System.out.println(new SearchRotateArray().search(new int[]{2, 5, 6, 7, 8, 1, 2}, 0));
    }
    public boolean search(int[] nums, int target) {

        if (nums.length == 0)
            return false;

        int left = 0, right = nums.length - 1, pivot = -1;

        while (left < right) {

            int mid = (left + right)/2;

            if (nums[mid] > nums[mid+1] ) {
                pivot = mid + 1;
                break;
            }

            if (nums[mid]<nums[mid-1]) {
                pivot = mid;
                break;
            }

            if (nums[mid] >= nums[right]) left = mid + 1;
            else right = mid-1;
        }

        if (pivot == -1)
            return binarySearch(nums, 0, nums.length - 1, target);

        if (nums[pivot] <= target && nums[nums.length - 1] >= target)
            return binarySearch(nums, pivot, nums.length - 1, target);
        else
            return binarySearch(nums, 0,pivot-1, target);

        // System.out.println(left + "--" + right);
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {

        if (left > right)
            return false;

        int mid = (left + right)/2;

        if (nums[mid] == target) return true;

        if (nums[mid] < target) return binarySearch(nums, left, mid - 1, target);
        else return binarySearch(nums, mid + 1, right, target);
    }
}

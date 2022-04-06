package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week3;

public class SortedArray {
    public static void main(String[] args) {
        new SortedArray().sortedSquares(new int[]{-5, -3, -2, -1});
    }

    public int[] sortedSquares(int[] nums) {

        int midPoint = -1, index = 0;
        int arr[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= 0) {
                midPoint = i;
                break;
            }

        int i = midPoint - 1, j = midPoint == -1 ? 0: midPoint;

        while (i >= 0 || j < nums.length) {

            if (i < 0) {
                arr[index++] = nums[j] * nums[j];
                j++;
            } else if (j >= nums.length) {
                arr[index++] = nums[i] * nums[i];
                i--;
            } else {
                if (Math.abs(nums[i]) < nums[j]) {
                    arr[index++] = nums[i] * nums[i];
                    i--;
                } else {
                    arr[index++] = nums[j] * nums[j];
                    j++;
                }
            }
        }

        if (midPoint == -1) {
            int p = 0, q = arr.length - 1;

            while (p < q) {
                int temp = arr[p];
                arr[p] = arr[q];
                arr[q] = temp;
                p++; q--;
            }
        }

        return arr;
    }
}

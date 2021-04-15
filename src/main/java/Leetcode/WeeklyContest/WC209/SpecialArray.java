package main.java.Leetcode.WeeklyContest.WC209;

public class SpecialArray {
    public static void main(String[] args) {
        new SpecialArray().specialArray(new int[]{0, 4, 3, 0, 4});
    }
    public int specialArray(int[] nums) {

        int n = nums.length;
        int arr[] = new int[n + 1];

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= n)
                arr[n]++;
            else
                arr[nums[i]]++;
        }

        int res = -1, count = 0;
        for (int i = n; i >= 0; i--) {
            if (count + arr[i] == i) {
                res = i;
                break;
            }
            count += arr[i];
        }

        return res;
    }
}

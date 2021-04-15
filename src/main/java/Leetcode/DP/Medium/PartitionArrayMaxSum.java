package main.java.Leetcode.DP.Medium;

public class PartitionArrayMaxSum {

    public static void main(String[] args) {
        System.out.println(new PartitionArrayMaxSum().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }

    int sum = 0;

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {

            int currMax = Integer.MIN_VALUE;
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i-j]: 0) + currMax * j);
            }
        }

        return dp[n-1];
    }

//    private void maxSumUtil(int[] arr, int k, int index, int subSum) {
//
//        sum = Math.max(subSum, sum);
//        if (index >= arr.length)
//            return;
//
//        int i = index;
//        int max = Integer.MIN_VALUE;
//        for (i = index; i < arr.length && i < (index + k); i++) {
//            max = Math.max(max, arr[i]);
//            maxSumUtil(arr, k, i + 1, subSum + (max * (i - index + 1)));
//        }
//        maxSumUtil(arr, k, index + 1, subSum + arr[index]);
//    }
}

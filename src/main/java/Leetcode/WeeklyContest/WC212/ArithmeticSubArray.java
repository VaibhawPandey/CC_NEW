package main.java.Leetcode.WeeklyContest.WC212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubArray {
    public static void main(String[] args) {
        new ArithmeticSubArray().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5});
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> res = new ArrayList<>();
        int dp[][] = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//
////                if (i == j) {
////                    dp[i][j] = true;
////                    continue;
////                }
//
//                int arr[] = new int[j - i + 1];
//                for (int k = 0; k <= j - i; k++)
//                    arr[k] = nums[i + k];
//
//                Arrays.sort(arr);
//
//                int diff = arr[1] - arr[0];
//                boolean tempRes = true;
//                for (int k = 1; k < j - i; k++) {
//                    if (arr[k + 1] - arr[k] != diff) {
//                        tempRes = false;
//                        break;
//                    }
//                }
//
//                dp[i][j] = tempRes;
//            }
//        }

        for (int i = 0; i < l.length; i++) {
            if (r[i] < l[i]) {
                res.add(false);
                continue;
            }
            if (dp[l[i]][r[i]] == -1) {

                int arr[] = new int[r[i] - l[i] + 1];
                for (int k = 0; k <= r[i] - l[i]; k++)
                    arr[k] = nums[l[i] + k];

                Arrays.sort(arr);

                int diff = arr[1] - arr[0];
                boolean tempRes = true;
                for (int k = 1; k < r[i] - l[i]; k++) {
                    if (arr[k + 1] - arr[k] != diff) {
                        tempRes = false;
                        break;
                    }
                }

                dp[l[i]][r[i]] = tempRes ? 1: 0;
            }

            res.add(dp[l[i]][r[i]] == 1);
    }

        return res;

}
}

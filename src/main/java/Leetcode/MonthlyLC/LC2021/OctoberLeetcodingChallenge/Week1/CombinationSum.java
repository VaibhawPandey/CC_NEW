package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8);
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        combinationSumUtil(candidates, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void combinationSumUtil(int[] candidates, ArrayList<Integer> subRes, int sum, int index) {

        if(sum < 0)
            return;

        if (sum == 0) {
            res.add(new ArrayList<>(subRes));
            return;
        }

        while (index < candidates.length && (sum - candidates[index] >= 0)) {
            subRes.add(candidates[index]);
            combinationSumUtil(candidates, subRes, sum - candidates[index], index);
            index++;
            subRes.remove(subRes.size() - 1);
        }
    }


//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        List<List<Integer>> res = new ArrayList<>();
//        int dp[][] = new int[candidates.length + 1][target + 1];
//
//        for (int i = 0; i <= candidates.length; i++) {
//            for (int j = 0; j <= target; j++) {
//
//                if (j == 0) {
//                    dp[i][j] = 1;
//                    continue;
//                }
//
//                if (i == 0)
//                    continue;
//
//                if (j >= candidates[i-1]) {
//                    dp[i][j] = dp[i-1][j] + dp[i][j - candidates[i-1]];
//                } else
//                    dp[i][j] = dp[i-1][j];
//            }
//        }
//
//        printDP(dp);
//
//        return res;
//    }
//
//    private void printDP(int[][] dp) {
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[i].length; j++) {
//                System.out.print(dp[i][j] +" ");
//            }
//            System.out.println();
//        }
//    }
}

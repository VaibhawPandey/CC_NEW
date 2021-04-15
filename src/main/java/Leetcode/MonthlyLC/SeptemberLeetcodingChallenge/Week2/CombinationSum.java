package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        new CombinationSum().combinationSum3(3, 9);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();
        combinationSumUtil(k, n, new ArrayList<Integer>(), res, 0, 1);

        return res;
    }

    private void combinationSumUtil(int k, int target, ArrayList<Integer> partRes, List<List<Integer>> res, int sum, int num) {

        if (sum == target && k == 0) {
            res.add(new ArrayList<>(partRes));
            return;
        }

        if (num > 9)
            return;

        partRes.add(num);
        sum += num;
        if (k > 0) combinationSumUtil(k - 1, target, partRes, res, sum, num + 1);
        partRes.remove(partRes.size() - 1);
        sum -= num;
        combinationSumUtil(k, target, partRes, res, sum, num + 1);

    }
}

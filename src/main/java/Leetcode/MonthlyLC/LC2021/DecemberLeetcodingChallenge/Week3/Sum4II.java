package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week3;

import java.util.HashMap;
import java.util.Map;

public class Sum4II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
               int sum = A[i] + B[j];
               map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                res += map.getOrDefault(sum * (-1), 0);
            }
        }

        return res;
    }
}

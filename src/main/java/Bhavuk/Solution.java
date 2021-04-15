package main.java.Bhavuk;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2,1,3}, 2));
    }

    public int solution(int[] A, int S) {

        long prefixSum = 0, res = 0;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        for (int i = 0; i < A.length; i++) {
            prefixSum += A[i] - S;
            if (map.getOrDefault(prefixSum, 0L) > 0)
                res += map.get(prefixSum);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0L) + 1);
        }

        if (res > 1000000000)
            return 1000000000;
        else
           return (int) res;
    }
//    public int solution(int[] A, int S) {
//
//        int currSum = 0, res = 0;
//
//        for (int i = 0; i < A.length; i++) {
//            currSum = 0;
//            for (int j = i; j < A.length; j++) {
//               currSum += A[j];
//               double val = (double) currSum / (double) (j - i + 1);
//               if (val == S)
//                   res++;
//            }
//        }
//
//        if (res > 1000000000)
//            return 1000000000;
//        else
//            return res;
//    }
}

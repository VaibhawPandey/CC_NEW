package main.java.Leetcode.WeeklyContest.WC213;


import java.util.*;

public class KthSmallestNumber {
    public static void main(String[] args) {
        new KthSmallestNumber().kthSmallestPath(new int[]{15, 15}, 5);
    }
    // List<String> res;
    Map<Long, Long> factMap;
    public String kthSmallestPath(int[] destination, int k) {

        factMap = new HashMap<>();
        int v_count = destination[0], h_count = destination[1];
        String res = "";
        int remaining_V_count = v_count;
        int start_with_H;

        for (int i = 0; i < v_count + h_count; i++) {
            start_with_H = comb(v_count + h_count - i - 1, remaining_V_count);

            if (k <= start_with_H) {
                res += "H";
            } else {
                res += "V";
                k -= start_with_H;
                remaining_V_count -= 1;
            }
        }

        return res;
//        res = new ArrayList<>();
//        solve(destination, 0, 0, "");
//        Collections.sort(res);

//        return res.get(k-1);
    }

    private int comb(int sum, int remaining_v_count) {
        long p = factMap.containsKey(sum) ? factMap.get(sum) : getFact(sum);
        long q = factMap.containsKey(sum - remaining_v_count) ? factMap.get(sum - remaining_v_count) : getFact(sum - remaining_v_count);
        long r = factMap.containsKey(remaining_v_count) ? factMap.get(remaining_v_count) : getFact(remaining_v_count);
        return (int) (p/(q * r));
    }

    private long getFact(long num) {
//        if (factMap.containsKey(num))
//            return factMap.get(num);

        int res = 1;
        factMap.put((long) 0, (long) 1);
        for (long i = 1; i <= num; i++) {
            factMap.put(i, res * i);
        }

        System.out.println(num);
        return factMap.get(num);
    }

//    private void solve(int[] destination, int i, int j, String subRes) {
//
//        if (destination[0] == i && destination[1] == j) {
//            res.add(subRes);
//            return;
//        }
//
//        if ((i + 1) <= destination[0]) solve(destination, i + 1, j, subRes +"V");
//        if ((j + 1) <= destination[1]) solve(destination, i, j + 1, subRes +"H");
//
//    }
}

package main.java.Leetcode.WeeklyContest.WC222;

import java.util.HashSet;
import java.util.Set;

public class CountGoodMeals {
    public static void main(String[] args) {
        new CountGoodMeals().countPairs(new int[]{1,1,1,3,3,3,7});
    }

    public int countPairs(int[] deliciousness) {

        int res = 0;

        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < deliciousness.length; i++)
            hashSet.add(deliciousness[i]);

        for (int i = 0; i <= 20; i++) {

            int key = (int) Math.pow(2, i);
            for (int j = 0; j < deliciousness.length && key >= deliciousness[j]; j++) {
                if (hashSet.contains(key-deliciousness[j]))
                    res = (res + 1) % 1000000007;
            }
        }


//        for (int i = 0; i < deliciousness.length; i++) {
//            for (int j = i + 1; j < deliciousness.length; j++) {
//
//                int temp = deliciousness[i] + deliciousness[j];
//                if (temp != 0 && (temp & (temp - 1)) == 0)
//                    res++;
//            }
//        }

        return res;
    }
}

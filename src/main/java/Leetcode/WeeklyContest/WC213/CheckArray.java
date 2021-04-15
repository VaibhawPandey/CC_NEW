package main.java.Leetcode.WeeklyContest.WC213;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckArray {
    public static void main(String[] args) {
        new CheckArray().canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78},{4,64},{91}});
    }
    public boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            List<int[]> list = map.getOrDefault(pieces[i][0], new ArrayList<>());
            list.add(pieces[i]);
            map.put(pieces[i][0], list);
        }

        for (int i = 0; i < arr.length; i++) {
            boolean isMatched = true;
            if (!map.containsKey(arr[i]))
                return false;

            int k = i;
            for (int[] subArr: map.get(Integer.valueOf(arr[i]))) {
                k = i;
                for (int a: subArr) {
                    if (k >= arr.length || arr[k] != a) {
                        isMatched = false;
                        break;
                    }
                    k++;
                }

                if (isMatched)
                    break;
            }

            if (isMatched)
                i = k - 1;
            else
                return false;
        }

        return true;
    }
}

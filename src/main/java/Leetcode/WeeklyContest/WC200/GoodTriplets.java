package main.java.Leetcode.WeeklyContest.WC200;

import java.util.ArrayList;
import java.util.List;

public class GoodTriplets {

    int count = 0;
    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        List<Integer> idxList = new ArrayList<Integer>();
        countTrip(arr, a, b, c, 0, idxList);

        return count;
    }

    private void countTrip(int[] arr, int a, int b, int c, int index, List<Integer> idxList) {

        if (idxList.size() == 3) {
            if (Math.abs(idxList.get(0) - idxList.get(1)) <= a &&
                    Math.abs(idxList.get(1) - idxList.get(2)) <= b &&
                    Math.abs(idxList.get(0) - idxList.get(2)) <= c) {
                count++;
            }
            return;
        }

        if (index >= arr.length)
            return;

        idxList.add(arr[index]);
        countTrip(arr, a, b, c, index + 1, idxList);

        idxList.remove(idxList.size() - 1);
        countTrip(arr, a, b, c, index + 1, idxList);
    }
}

package main.java.Leetcode.WeeklyContest.WC222;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumUnits {
    public static void main(String[] args) {
        new MinimumUnits().maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4);
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? -1: 1;
            }
        });

        int res = 0, index = 0;
        while (truckSize > 0 && index < boxTypes.length) {

            if (boxTypes[index][0] <= truckSize) {
                res += (boxTypes[index][0] * boxTypes[index][1]);
                truckSize -= boxTypes[index][0];
                index++;
            } else {
                res += boxTypes[index][1];
                truckSize--;
            }
        }

        return res;
    }
}

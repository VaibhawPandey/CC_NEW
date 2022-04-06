package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week2;

import java.util.Arrays;
import java.util.HashSet;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(getDist(p1, p2), getDist(p1, p3), getDist(p1, p4), getDist(p2, p3),
                getDist(p2, p4), getDist(p3, p4)));
        return !hashSet.contains(0) && hashSet.size() == 2;
    }

    private int getDist(int[] p1, int[] p2) {
        return ((p1[0] - p2[0]) * (p1[0] - p2[0])) + ((p1[1] - p2[1]) * (p1[1] - p2[1]));
    }
}

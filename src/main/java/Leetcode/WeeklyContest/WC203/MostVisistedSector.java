package main.java.Leetcode.WeeklyContest.WC203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MostVisistedSector {

    public static void main(String[] args) {
        new MostVisistedSector().mostVisited(4, new int[]{1, 3, 1, 2});
    }

    public List<Integer> mostVisited(int n, int[] rounds) {

        int arr[] = new int[n + 1];
        int mostVisitedSector = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < rounds.length - 1; i++) {

            int range = rounds[i + 1];
            if (rounds[i] > range)
                range += n;

            int start = rounds[i];
            if (i != 0)
                start++;

            for (int j = start; j <= range; j++) {

                int index = j;
                if (j > n)
                    index = index % n;

                arr[index]++;

                if (arr[index] > mostVisitedSector) {
                    mostVisitedSector = arr[index];
                    res = new ArrayList<>();
                    res.add(index);
                } else if (arr[index] == mostVisitedSector)
                         res.add(index);
            }
        }

        Collections.sort(res);

        return res;

    }
}

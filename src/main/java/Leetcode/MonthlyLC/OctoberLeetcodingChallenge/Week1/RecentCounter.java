package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week1;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter {

    int start, end, index, res;
    List<Integer> arrList;

    public RecentCounter() {

        start = -1;
        end = -1;
        index = -1;
        res = 0;
        arrList = new ArrayList<>();

    }

    public int ping(int t) {

        arrList.add(t);
        if (start == -1) {
            start = t;
            end = t + 3000;
            index = 0;
        } else {

            if (t > end) {

                while (t > end) {
                    res--;
                    index++;
                    end = arrList.get(index) + 3000;
                }
            }
        }
        res++;
        return res;
    }
}

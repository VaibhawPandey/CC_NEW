package main.java.Leetcode.WeeklyContest.WC219;

public class CountMatches {
    public int numberOfMatches(int n) {

        int noOfMatches = 0;
        while (n > 1) {

            noOfMatches += n/2;
            n = n % 2 == 0 ? n/2: n/2 + 1;

        }

        return noOfMatches;
    }
}

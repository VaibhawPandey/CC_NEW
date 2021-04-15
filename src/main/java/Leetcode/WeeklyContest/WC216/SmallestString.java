package main.java.Leetcode.WeeklyContest.WC216;

public class SmallestString {
    public String getSmallestString(int n, int k) {

        if (k < n)
            return "";

        int arr[] = new int[n];
        k -= n;
        int index = n -1;

        while (k > 0) {
            if (k >= 25) {
                k -= 25;
                arr[index] += 25;
            } else {
                arr[index] += k;
                k = 0;
            }
            index--;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append((char) ('a' + arr[index]));
        }

        return res.toString();
    }
}

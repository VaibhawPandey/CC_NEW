package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week3;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {

        int arr[] = new int[1001];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < trips.length; i++) {
            min = Math.min(min, trips[i][1]);
            max = Math.max(max, trips[i][2]);

            arr[trips[i][1]] += trips[i][0];
            arr[trips[i][2]] -= trips[i][1];
        }

        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += arr[i];

            if (sum > capacity)
                return false;
        }

        return true;
    }
}

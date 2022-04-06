package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week2;

public class PairsofSong {
    public static void main(String[] args) {
        System.out.println(new PairsofSong().numPairsDivisibleBy60(new int[]{174,188,377,437,54,498,455,239,183,347,59,199,52,488,147,82}));
    }
    public int numPairsDivisibleBy60(int[] time) {

        int arr[] = new int[60];

        for (int i = 0; i < time.length; i++)
            arr[time[i] % 60]++;

        int i = 1, j = arr.length-1;
        int res = arr[0] > 1 ? arr[0]: 0;

        while (i < j) {
            int temp = Math.min(arr[i], arr[j]);
            res += temp;
            if (temp > 0) {
                System.out.println(i +"--" + j);
            }
            i++; j--;
        }

        res += arr[30] > 1 ? arr[30] : 0;

        return res;
    }
}

package main.java.Leetcode.WeeklyContest.WC204;

public class DetectPattern {

    public static void main(String[] args) {
        System.out.println(new DetectPattern().containsPattern(new int[]{6,3,5,5,5,5,1,5,6,2,5,1,2,5,3,5,1,3,5,5,6,4,1,2}, 1, 5));
    }
    public boolean containsPattern(int[] arr, int m, int k) {

        int p = 0, r = 0;
        for (int i = 0; i < arr.length; i++) {

            while (i + m < arr.length && arr[i] == arr[i+m]) {
                r++;
                if (r == m) {
                    p++;
                    r = 0;
                }
                i++;
            }

            if (p >= k - 1)
                return true;

            r = 0;
            p = 0;
        }

        return false;
    }
}

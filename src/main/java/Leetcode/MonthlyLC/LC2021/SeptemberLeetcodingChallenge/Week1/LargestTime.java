package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week1;

public class LargestTime {
    String res = "";
    public String largestTimeFromDigits(int[] A) {

        String res = "";
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < A.length; k++) {

                    if (i == j || i == k || j == k) continue;
                    String hour = "" + A[i] + A[j];
                    String minute = "" +A[k] + A[6-i-j-k];
                    String time = hour +":" +minute;

                    if (hour.compareTo("24") < 0 && minute.compareTo("60") < 0 && res.compareTo(time) < 0)
                        res = time;
                }
            }
        }

        return res;
    }

}

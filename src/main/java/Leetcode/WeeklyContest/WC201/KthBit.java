package main.java.Leetcode.WeeklyContest.WC201;

public class KthBit {

    public char findKthBit(int n, int k) {

        String arr[] = new String[n];

        int i = 1;
        arr[0] = "0";
        while (i < n) {

            if (arr[i-1].length() >= k)
                return arr[i-1].charAt(k-1);
            if (i >= 2)
                arr[i] = arr[i-1] + '1' + arr[i-1].substring(0, arr[i-2].length()) + '0' + arr[i-1].substring(arr[i-2].length() + 1);
                else
                 arr[i] = arr[i-1] + '1' + reverseInvert(arr[i-1]);
            i++;
        }

        return arr[n-1].charAt(k-1);
    }

    public String reverseInvert(String s) {

        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '1') res += '0';
            else res += '1';
        }

        return res;
    }
}

package main.java.Leetcode.MonthlyLC.LC2022.MarchLC;

public class ReverseString {

    public void reverseString(char[] s) {
        int l = 0, h = s.length - 1;

        while (l <= h) {
            char temp = s[h];
            s[h] = s[l];
            s[l] = temp;
            l++; h--;
        }
    }
}

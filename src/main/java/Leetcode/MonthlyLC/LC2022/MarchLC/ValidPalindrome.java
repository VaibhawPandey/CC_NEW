package main.java.Leetcode.MonthlyLC.LC2022.MarchLC;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().validPalindrome("axbcbaba"));
    }

    public boolean validPalindrome(String st) {
//        int s = 0, e = st.length() - 1;
//        char str[] = st.toCharArray();
//
//        while (s < e) {
//            if (str[s] == str[e]) {
//                s++; e--;
//            } else {
//
//            }
//        }
        return true;
    }

    // Alternative
    public boolean isValid(char str[], int s, int e, int count) {
        if (s >= e) return true;

        if (str[s] != str[e]) {
            if (count == 0) return false;
            if (e-s == 1) return true;

            if (str[s] == str[e-1] && str[s+1] == str[e]) return (isValid(str, s + 1, e - 2, 0) || isValid(str, s + 2, e - 1, 0));
            if (str[s] == str[e-1]) return isValid(str, s + 1, e - 2, 0);
            else if (str[s+1] == str[e]) return isValid(str, s + 2, e - 1, 0);
            else return false;
        }

        return isValid(str, s + 1, e - 1, count);
    }
}

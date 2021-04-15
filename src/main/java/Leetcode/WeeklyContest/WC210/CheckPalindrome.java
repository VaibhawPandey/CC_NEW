package main.java.Leetcode.WeeklyContest.WC210;

public class CheckPalindrome {
    public static void main(String[] args) {
        System.out.println(new CheckPalindrome().checkPalindromeFormation("abda", "acmc"));
    }
//    public boolean checkPalindromeFormation(String a, String b) {
//
//        for (int i = 0; i < a.length(); i++) {
//            String s1 = a.substring(0, i);
//            String s2 = a.substring(i, a.length());
//            String s3 = b.substring(0, i);
//            String s4 = b.substring(i, b.length());
//
//            if (isPalindrome(s1 + s4) || isPalindrome(s2 + s3))
//                return true;
//        }
//
//        return false;
//    }

    public boolean checkPalindromeFormation(String a, String b) {

        int i = 0, j = 0, n = a.length();
        char aChar[] = a.toCharArray();
        char bChar[] = b.toCharArray();

        while (i <= n/2 && aChar[i] == bChar[n - i - 1])
            i++;

        while (j <= n/2 && bChar[j] == aChar[n - j - 1])
            j++;

        int index = Math.max(i, j);
        int left = index, right = n - 1 - index;

        if (i >= j) {

            while (right - left >= 1 && bChar[left] == bChar[right]) {
                left++;
                right--;
            }

            if (right - left < 1)
                return true;

        }
        left = index; right = n - 1 - index;
        if (j >= i) {

            while (right - left >= 1 && aChar[left] == aChar[right]) {
                left++;
                right--;
            }

            if (right - left < 1)
                return true;
        }

        return false;
    }



//    public boolean checkPalindromeFormation(String a, String b) {
//
//        if (isPalindrome(a) || isPalindrome(b))
//            return true;
//
//        boolean check = check(a, b);
//        return check ? true : check(b, a);
//    }
//
//    private boolean check(String a, String b) {
//
//        int st = 0, end = a.length() - 1;
//        char aChar[] = a.toCharArray();
//        char bChar[] = b.toCharArray();
//        while (st < end) {
//            if (aChar[st] == bChar[end]) {
//                st++;
//                end--;
//            } else {
//                break;
//            }
//        }
//
//        if (st >= end)
//            return true;
//
//        return false;
//    }
//
//    private boolean isPalindrome(String a) {
//        int st = 0, end = a.length() - 1;
//        while (st < end) {
//            if (a.charAt(st) == a.charAt(end)) {
//                st++;
//                end--;
//            } else
//                return false;
//        }
//
//        return true;
//    }
}

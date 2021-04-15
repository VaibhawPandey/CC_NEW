package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week1;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        String updatedS = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        for (int i = 0; i < updatedS.length(); i++) {
            if (updatedS.charAt(i) != updatedS.charAt(updatedS.length() - i - 1))
                return false;
        }

        return true;
    }
}

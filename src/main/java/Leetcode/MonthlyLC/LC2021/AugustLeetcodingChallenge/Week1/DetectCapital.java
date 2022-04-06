package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week1;

public class DetectCapital {

    public static void main(String[] args) {
        new DetectCapital().detectCapitalUse("Google");
    }

    public boolean detectCapitalUse(String word) {

        boolean isCamelCaseWord = false, isUpperCaseWord = false, isLowerCaseWord = false;
        if (word.length() >= 2) {
            boolean isFirstCharUpperCase = Character.isUpperCase(word.charAt(0));
            boolean isSecondCharUpperCase = Character.isUpperCase(word.charAt(1));

            if (isFirstCharUpperCase && isSecondCharUpperCase)
                isUpperCaseWord = true;
            else if (isFirstCharUpperCase && !isSecondCharUpperCase)
                isCamelCaseWord = true;
            else if (!isFirstCharUpperCase && !isSecondCharUpperCase)
                isLowerCaseWord = true;
            else
                return false;
        }

        for (int i = 1; i < word.length(); i++) {

            if ((isCamelCaseWord || isLowerCaseWord) && Character.isUpperCase(word.charAt(i)))
                return false;

            if (isUpperCaseWord && Character.isLowerCase(word.charAt(i)))
                return false;

        }

        return true;
    }
}

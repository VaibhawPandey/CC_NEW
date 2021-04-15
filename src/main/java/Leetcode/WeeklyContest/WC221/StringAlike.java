package main.java.Leetcode.WeeklyContest.WC221;

public class StringAlike {
    public boolean halvesAreAlike(String s) {

        int count1 = 0, count2 = 0;
        int len = s.length(), halfLen = len/2;

        for (int i = 0; i < len; i++) {
            if (i < halfLen && charIsVowel(s.charAt(i))) {
                count1++;
            } else if (charIsVowel(s.charAt(i))){
                count2++;
                if (count2 > count1)
                    break;
            }
        }

        if (count1 == count2)
            return true;

        return false;
    }

    private boolean charIsVowel(char c) {

        c = Character.toLowerCase(c);

        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;

        return false;
    }
}

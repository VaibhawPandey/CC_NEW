package main.java.Leetcode.BiWeeklyContest.C32;

import java.util.ArrayList;
import java.util.List;

public class ConvertString {

    public boolean canConvertString(String s, String t, int k) {

        if (s.length() != t.length()) return false;

        int diffList[] = new int[26];
        // int sum[][] = new int[27][27];

        for (int i = 0; i < s.length(); i++) {

            int charS = s.charAt(i) - 'a' + 1;
            int charT = t.charAt(i) - 'a' + 1;
            if (charS != charT) {

                int diff = charT - charS;
                if (diff < 0) diff += 26;

                int difference = diff;
                diff = diffList[diff] != 0 ? diffList[diff]: diff;

                if (diff > k)
                    return false;

                diffList[difference] = diff + 26;
            }
        }

        return true;
    }
}

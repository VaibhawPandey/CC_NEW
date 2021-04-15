package main.java.Leetcode.WeeklyContest.WC214;

import java.util.HashSet;

public class MinDeletion {
    public int minDeletions(String s) {

        char sChar[] = s.toCharArray();
        int charCount[] = new int[26];

        for (int i = 0; i < sChar.length; i++)
            charCount[sChar[i] - 'a']++;

        HashSet<Integer> countSet = new HashSet<>();
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (countSet.contains(charCount[i])) {
                 int temp = charCount[i];
                 while (temp > 0 && countSet.contains(temp))
                     temp--;

                 res += charCount[i] - temp;
                 countSet.add(temp);
            } else
                countSet.add(charCount[i]);
        }

        return res;
    }
}

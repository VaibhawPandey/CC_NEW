package main.java.Leetcode.WeeklyContest.WC211;

public class LargestSubstring {
    public int maxLengthBetweenEqualCharacters(String s) {

        int count[] = new int[26];
        char cArray[] = s.toCharArray();

        int maxLength = -1;
        for (int i = 1; i <= cArray.length; i++) {
            if (count[cArray[i-1] - 'a'] != 0)
                maxLength = Math.max(maxLength, i - count[cArray[i-1] - 'a'] - 1);
            else
                count[cArray[i-1] - 'a'] = i;
        }

        return maxLength;
    }
}

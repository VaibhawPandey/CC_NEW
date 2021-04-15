package main.java.Leetcode.WeeklyContest.WC216;

public class CheckString {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder word1SB = new StringBuilder();
        StringBuilder word2SB = new StringBuilder();

        for (int i = 0; i < word1.length; i++)
            word1SB.append(word1[i]);

        for (int i = 0; i < word2.length; i++)
            word2SB.append(word2[i]);

        return word1SB.toString().equals(word2SB.toString());
    }
}

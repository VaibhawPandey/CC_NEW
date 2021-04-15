package main.java.Leetcode.WeeklyContest.WC215;

import java.util.HashMap;
import java.util.Map;

public class CloseString {
    public static void main(String[] args) {
        new CloseString().closeStrings("kkkkkkkkkkkkkkkkkkkukkkkkkkkkkkkkkkkrkkukkkkkkkkkkkkkkkkkkkkkkkkkkkkkkrukkkkkkkkkkkrkkkr",
                "rrrrrkrrruukrrrkrkrkrrrrrurrrrrrrrrrrrrrrurkrrrrrrurkurrrrurrrrrrrrrrururrurrurrrrrrrrrr");
    }
    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length())
            return false;

        char wordChar1[] = word1.toCharArray();
        char wordChar2[] = word2.toCharArray();

        int n = word1.length();
        int alphabet1[] = new int[26];
        int alphabet2[] = new int[26];

        int noOfDiffChar1 = 0, noOfDiffChar2 = 0;

        for (int i = 0; i < n; i++) {
            alphabet1[wordChar1[i] - 'a']++;
            alphabet2[wordChar2[i] - 'a']++;
            if (alphabet1[wordChar1[i] - 'a'] == 1)
                noOfDiffChar1++;
            if (alphabet2[wordChar2[i] - 'a'] == 1)
                noOfDiffChar2++;
        }

        if (noOfDiffChar1 != noOfDiffChar2)
            return false;

        Map<Integer, Integer> alpCount1 = new HashMap<>();
        Map<Integer, Integer> alpCount2 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (alphabet1[i] == 0 && alphabet2[i] == 0)
                continue;

            if (alphabet1[i] == 0 || alphabet2[i] == 0)
                return false;

            alpCount1.put(alphabet1[i], alpCount1.getOrDefault(alphabet1[i], 0) + 1);
            alpCount2.put(alphabet2[i], alpCount2.getOrDefault(alphabet2[i], 0) + 1);
        }

        if (alpCount1.size() != alpCount2.size())
            return false;

        for (Map.Entry entry: alpCount1.entrySet()) {
            if (entry.getValue() != alpCount2.getOrDefault(entry.getKey(), 0))
                return false;
        }

        return true;
    }
}

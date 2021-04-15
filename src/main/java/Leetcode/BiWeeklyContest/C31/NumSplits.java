package main.java.Leetcode.BiWeeklyContest.C31;

import java.util.Arrays;

public class NumSplits {

    public static void main(String[] args) {
        System.out.println(new NumSplits().numSplits("aacaba"));
    }
    public int numSplits(String s) {

        int n = s.length();

        boolean charAppeared[] = new boolean[26];
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (charAppeared[s.charAt(i) - 'a'] == true)
                prefix[i] = prefix[i-1];
            else {
                prefix[i] = (i - 1) < 0 ? 1 : prefix[i - 1] + 1;
                charAppeared[s.charAt(i) - 'a'] = true;
            }
        }

        Arrays.fill(charAppeared, false);

        for (int i = n-1; i > 0; i--) {
            if (charAppeared[s.charAt(i) - 'a'] == true)
                suffix[i-1] = suffix[i];
            else {
                suffix[i-1] = (i == (n - 1)) ? 1 : suffix[i] + 1;
                charAppeared[s.charAt(i) - 'a'] = true;
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i])
                res++;
        }

        return res;

    }
}

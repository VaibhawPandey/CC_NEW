package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {

        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i = 0; i < s.length() - 10; i++) {
            String subString = s.substring(i, i + 10);
            if (seen.contains(subString))
                repeated.add(subString);
            else
               seen.add(subString);
        }

        List<String> res = new ArrayList<>();
        for (String str: repeated)
            res.add(str);

        return res;
    }
}

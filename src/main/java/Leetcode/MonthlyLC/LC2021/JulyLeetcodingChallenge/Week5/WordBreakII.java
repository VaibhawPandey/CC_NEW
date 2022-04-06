package main.java.Leetcode.MonthlyLC.LC2021.JulyLeetcodingChallenge.Week5;

import java.util.*;

public class WordBreakII {

    public static void main(String[] args) {
        List<String> out = new WordBreakII().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
    }

    Map<Integer, List<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {

        map = new HashMap<>();
        return wordBreakInsert(s, s.length(), wordDict);
    }

    private List<String> wordBreakInsert(String s, int end, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        if (end == 0) return new ArrayList<>(Arrays.asList(""));

        if (map.containsKey(end))
            return map.get(end);

        for (int start = 0; start < end; start++) {

            String part = s.substring(start, end);
            if (wordDict.contains(part)) {

                List<String> tmpList = wordBreakInsert(s, start, wordDict);
                for (String tmp: tmpList)
                    res.add(tmp.length() == 0 ? part: tmp +" " +part);
            }
        }
        map.put(end, res);

        return res;
    }
}

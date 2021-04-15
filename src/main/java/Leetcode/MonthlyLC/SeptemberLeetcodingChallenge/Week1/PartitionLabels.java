package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week1;

import java.util.*;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        List<Integer> res = new ArrayList<>();
        int count[] = new int[26];

        for (int i = 0; i < S.length(); i++)
            count[S.charAt(i) - 'a'] = i;

        int start = 0;
        while (start < S.length()) {
            int end = getLastPosition(start, S, count);
            res.add(end - start + 1);
            start = end + 1;
        }

        return res;
    }

    private int getLastPosition(int start, String s, int[] count) {

        int max = count[s.charAt(start) - 'a'], pos = start + 1;

        while (pos < max) {
            max = Math.max(max, count[s.charAt(pos) - 'a']);
            pos++;
        }

        return max;
    }

    // Alternative
//    public List<Integer> partitionLabels(String S) {
//
//        List<Integer> res = new ArrayList<>();
//        Map<Character, Integer> map = new HashMap<>();
//        Set<Character> charSet = new HashSet<>();
//
//        for (int i = 0; i < S.length(); i++)
//            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
//
//        int startOfLastSubString = 0;
//        for (int i = 0; i < S.length(); i++) {
//            map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
//
//            if (map.get(S.charAt(i)) == 0) {
//
//                boolean isLastChar = true;
//                for (int j = startOfLastSubString; j <= i; j++) {
//                    if (map.get(S.charAt(j)) > 0) {
//                        isLastChar = false;
//                        break;
//                    }
//                }
//
//                if (isLastChar) {
//                    res.add(i - startOfLastSubString + 1);
//                    startOfLastSubString = i + 1;
//                }
//            }
//        }
//
//        return res;
//    }
}

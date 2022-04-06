package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week2;

import java.util.HashSet;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2)
             return false;

        char ACharArray[] = A.toCharArray();
        char BCharArray[] = B.toCharArray();

        if (A.equalsIgnoreCase(B)) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < ACharArray.length; i++) {
                if (set.contains(ACharArray[i]))
                    return true;
                 else
                    set.add(ACharArray[i]);
            } }

        char A1 = 'a', B1 = 'a';
        int j = 0;

        for (int i = 0; i < ACharArray.length && j < 3; i++) {
            if (ACharArray[i] != BCharArray[i]) {
                j++;
                if (j == 1) {
                    A1 = ACharArray[i];
                    B1 = BCharArray[i];
                }
                if (j == 2 && (ACharArray[i] != B1 || BCharArray[i] != A1))
                    return false;
            }
        }

        return j == 2;
    }
//    public boolean buddyStrings(String A, String B) {
//
//        if (A.length() != B.length() || A.length() < 2)
//            return false;
//
//        int alphabetCount[] = new int[26];
//        int bAlphabetCount[] = new int[26];
//        char ACharArray[] = A.toCharArray();
//        char BCharArray[] = B.toCharArray();
//        int maxAlphabetCount = Integer.MIN_VALUE;
//        int diffCount = 0;
//
//        for (int i = 0; i < A.length(); i++) {
//            char c = ACharArray[i];
//            char d = BCharArray[i];
//            if (c != d) {
//                diffCount++;
//                if (diffCount > 2)
//                    return false;
//            }
//            bAlphabetCount[d - 'a']++;
//            alphabetCount[c - 'a']++;
//            maxAlphabetCount = Math.max(alphabetCount[c - 'a'], maxAlphabetCount);
//        }
//
//        for (int i = 0; i < 26; i++) {
//          if (alphabetCount[i] != bAlphabetCount[i])
//              return false;
//        }
//        if (diffCount == 2 || (diffCount == 0 && maxAlphabetCount > 1))
//            return true;
//
//        return false;
//    }
}

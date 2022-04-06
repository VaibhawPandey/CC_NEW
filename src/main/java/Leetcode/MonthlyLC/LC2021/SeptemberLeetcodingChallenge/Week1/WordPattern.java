package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week1;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String str) {

        String strWord[] = str.split(" ");

        if (pattern.length() != strWord.length)
            return false;

       Map<Character, String> map = new HashMap<>();
       Map<String, Character> reverseMap = new HashMap<>();

        for (int i = 0; i < strWord.length; i++) {
           if (map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(strWord[i]))
               return false;

           if (reverseMap.containsKey(strWord[i]) && reverseMap.get(strWord[i]) != pattern.charAt(i))
               return false;

           map.put(pattern.charAt(i), strWord[i]);
           reverseMap.put(strWord[i], pattern.charAt(i));
        }

        return true;
     }
}

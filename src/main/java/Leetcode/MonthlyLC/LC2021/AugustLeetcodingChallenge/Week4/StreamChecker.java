package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week4;

import java.util.Arrays;

public class StreamChecker {

    class Trie {

        Trie children[];
        boolean endofWord;

        Trie() {
            children = new Trie[26];
            // Arrays.fill(children, null);
            endofWord = false;
        }
    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"ab", "f", "cd"});
        streamChecker.query('a');
        streamChecker.query('b');
    }

    Trie root;
    Trie triePosition;
    int maxWordLength = Integer.MIN_VALUE;
    StringBuilder queryList = new StringBuilder();

    public StreamChecker(String[] words) {

        root = new Trie();

        for (String word: words) {
            Trie temp = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (temp.children[word.charAt(i) - 'a'] == null)
                temp.children[word.charAt(i) - 'a'] = new Trie();
                temp =  temp.children[word.charAt(i) - 'a'];
            }
            temp.endofWord = true;
            maxWordLength = Math.max(maxWordLength, word.length());
        }
    }


    public boolean query(char letter) {

        queryList.append(letter);
        triePosition = root;

        for (int i = queryList.length() - 1; i >= 0 && i >= queryList.length() - maxWordLength && null != triePosition; i--) {
            triePosition = triePosition.children[queryList.charAt(i) - 'a'];
            if (triePosition != null && triePosition.endofWord)
                return true;
        }

        return false;
    }
}

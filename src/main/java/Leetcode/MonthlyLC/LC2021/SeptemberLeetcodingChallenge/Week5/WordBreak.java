package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList(new String[]{"apple","pen"})));
    }
    class Trie {
        Character c;
        Trie children[];
        boolean endOfWord;

        Trie() {
            children = new Trie[26];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;

        HashSet<String> hashSet = new HashSet<>();
        for (String str: wordDict)
            hashSet.add(str);

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }



//    public boolean wordBreak(String s, List<String> wordDict) {
//
//        Trie root = new Trie();
//        for (String str: wordDict) {
//            char strC[] = str.toCharArray();
//            Trie currentTrie = root;
//            for (int i = 0; i < strC.length; i++) {
//                if (currentTrie.children[strC[i] - 'a'] == null)
//                    currentTrie.children[strC[i] - 'a'] = new Trie();
//
//                // currentTrie.children[strC[i] - 'a'] = new Trie();
//                currentTrie = currentTrie.children[strC[i] - 'a'];
//            }
//            currentTrie.endOfWord = true;
//        }
//
//        char sC[] = s.toCharArray();
//
//        return solve(root, sC, 0, root);
//    }
//
//    private boolean solve(Trie currentTrie, char[] sC, int i, Trie root) {
//
//        if (currentTrie.children[sC[i] - 'a'] == null)
//            return false;
//
//        boolean res = true;
//        if (currentTrie.children[sC[i] - 'a'].endOfWord) {
//            if (i == sC.length - 1)
//                return true;
//
//            res = solve(currentTrie.children[sC[i] - 'a'], sC, i + 1, root) | solve(root, sC, i + 1, root);
//        }
//        else {
//            if (i == sC.length - 1)
//                return false;
//
//            res = solve(currentTrie.children[sC[i] - 'a'], sC, i + 1, root);
//        }
//
//        return res;
//    }
}

package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week1;

public class WordDictionary {

    class Trie {

        Trie children[];
        boolean isEndofWord;

        Trie() {
            children = new Trie[26];

            for (int i = 0; i < 26; i++)
                children[i] = null;

            isEndofWord = false;
        }
    }
    /** Initialize your data structure here. */
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie currTrie = root;
        for (int i = 0; i < word.length(); i++) {
            if (currTrie.children[word.charAt(i) - 'a'] == null)
                currTrie.children[word.charAt(i) - 'a'] = new Trie();

            currTrie = currTrie.children[word.charAt(i) - 'a'];
        }

        currTrie.isEndofWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return wordSearch(root, word, 0);
    }

    private boolean wordSearch(Trie trie, String word, int index) {

        if (index == word.length())
            if (trie.isEndofWord)
                return true;
            else
                return false;

        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++)
                if (trie.children[i] != null && wordSearch(trie.children[i], word, index + 1))
                    return true;
        } else if (trie.children[word.charAt(index) - 'a'] != null)
                  return wordSearch(trie.children[word.charAt(index) - 'a'], word, index + 1);

        return false;
    }
}

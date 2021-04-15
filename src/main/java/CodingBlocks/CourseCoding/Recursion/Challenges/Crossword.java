package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.*;

public class Crossword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String words[] = new String[n];
        for (int i = 0; i < n; i++)
            words[i] = scanner.next();
        int clen = scanner.nextInt();
        char crossword[][] = new char[clen][clen];

        for (int i = 0; i < clen; i++) {
            String cRow = scanner.next();
            for (int j = 0; j < clen; j++)
                crossword[i][j] = cRow.charAt(j);
        }
        int isAvailable[][] = new int[clen][clen];
        Set<String> resList = new LinkedHashSet<>();
        int direction[][] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < words.length; i++) {
            if (!resList.contains(words[i])) {
                char w[] = words[i].toCharArray();
                wordsAvailableinCrossword(crossword, w, 0, words[i].length(), clen, resList, 0, 0, isAvailable, direction);
            }
        }
        for (String res: resList) {
            System.out.print(res + " ");
        }
        scanner.close();
    }

    private static boolean wordsAvailableinCrossword(char[][] crossword, char[] word, int pos, int wordLen, int clen, Set<String> res, int i, int j, int[][] isAvailable, int[][] direction) {
        if (pos == wordLen) {
            res.add(String.valueOf(word));
            return true;
        }

        if (i == clen) return false;
        if (j == clen)
            return wordsAvailableinCrossword(crossword, word, 0, wordLen, clen, res, i + 1, 0, isAvailable, direction);
        if (pos == 0 && crossword[i][j] != word[pos])
            return wordsAvailableinCrossword(crossword, word, pos, wordLen, clen, res, i, j + 1, isAvailable, direction);

        isAvailable[i][j] = 1;
        for (int k = 0; k < direction.length; k++) {
            int p = i + direction[k][0], q = j + direction[k][1];
            if (isValid(p, q, clen) && isAvailable[p][q] != 1 && crossword[i][j] == word[pos]) {
                boolean available = wordsAvailableinCrossword(crossword, word, pos + 1, wordLen, clen, res, p, q, isAvailable, direction);
                if (available) {
                    isAvailable[i][j] = 0;
                    return true;
                }
            }
        }

        isAvailable[i][j] = 0;

        return false;
    }

    private static boolean isValid(int p, int q, int clen) {
        if (p < 0 || q < 0 || p >= clen || q >= clen)
            return false;

        return true;
    }
}

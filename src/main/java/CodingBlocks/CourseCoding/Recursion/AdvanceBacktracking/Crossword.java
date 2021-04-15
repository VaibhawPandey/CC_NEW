package main.java.CodingBlocks.CourseCoding.Recursion.AdvanceBacktracking;

import java.util.Scanner;

/**
 * HackerRank Problem
 */
public class Crossword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 10;
        String crossword[] = new String[10];
        for (int i = 0; i < n; i++)
            crossword[i] = scanner.next();
        String words = scanner.next();
        crossword = crosswordPuzzle(crossword, words);
        for (int i = 0; i < crossword.length; i++)
            System.out.println(crossword[i]);
        scanner.close();
    }
    static String[] crosswordPuzzle(String[] crossword, String words) {

        char crossWord[][] = new char[crossword.length][crossword[0].length()];

        for (int i = 0; i < crossword.length; i++) {
            char c[] = crossword[i].toCharArray();
            for (int j = 0; j < c.length; j++)
                crossWord[i][j] = c[j];
        }

        String wordList[] = words.split(";");
        placeWords(crossWord, wordList, 0, 0);
        for (int i = 0; i < crossWord.length; i++)
            crossword[i] = String.valueOf(crossWord[i]);

        return crossword;
    }

    private static boolean placeWords(char[][] crossWord, String[] wordList, int index, int numberOfWordsPlaced) {
        if (index >= wordList.length) {
            if (numberOfWordsPlaced == wordList.length) return true;
            return false;
        }

        int m = crossWord.length, n = crossWord[0].length;
        String word = wordList[index];

        // Check Vertically
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((crossWord[i][j] == '-' || crossWord[i][j] == word.charAt(0)) && (n - j) >= word.length()) {
                    boolean placed[][] = new boolean[m][n];
                    if (placeVertically(crossWord, word, i, j, j + word.length(), 0, placed)) {
                        boolean isAllPlaced = placeWords(crossWord, wordList, index + 1, numberOfWordsPlaced + 1);
                        if (isAllPlaced) return true;
                        unplaceWords(crossWord, placed);
                    }
                }
            }
        }

        // Check Horizontally
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if ((crossWord[i][j] == '-' || crossWord[i][j] == word.charAt(0)) && (m - i) >= word.length()) {
                    boolean placed[][] = new boolean[m][n];
                    if (placeHorizontally(crossWord, word, i, j, i + word.length(), 0, placed)) {
                        boolean isAllPlaced = placeWords(crossWord, wordList, index + 1, numberOfWordsPlaced + 1);
                        if (isAllPlaced) return true;
                        unplaceWords(crossWord, placed);
                    }
                }
            }
        }

        return false;
    }

    private static void unplaceWords(char[][] crossWord, boolean[][] placed) {
        for (int i = 0; i < crossWord.length; i++) {
            for (int j = 0; j < crossWord[i].length; j++) {
                if (placed[i][j])
                    crossWord[i][j] = '-';
            }
        }
    }

    private static boolean placeHorizontally(char[][] crossWord, String word, int start, int j, int end, int index, boolean[][] placed) {
        if (start == end) {
            if (end < crossWord.length && crossWord[start][j] != '+')
                return false;

            return true;
        }

        if (crossWord[start][j] == word.charAt(index)) return placeHorizontally(crossWord, word, start + 1, j, end, index + 1, placed);

        if (crossWord[start][j] == '-') {
            crossWord[start][j] = word.charAt(index);
            placed[start][j] = true;
            boolean isPlaced = placeHorizontally(crossWord, word, start + 1, j, end, index + 1, placed);
            if (isPlaced) return true;
            crossWord[start][j] = '-';
            placed[start][j] = false;
        }
        return false;
    }

    private static boolean placeVertically(char[][] crossWord, String word, int i, int start, int end, int index, boolean[][] placed) {
        if (start == end) {
            if (end < crossWord[0].length && crossWord[i][end] != '+')
                return false;

            return true;
        }

        if (crossWord[i][start] == word.charAt(index)) return placeVertically(crossWord, word, i, start + 1, end, index + 1, placed);

        if (crossWord[i][start] == '-') {
            crossWord[i][start] = word.charAt(index);
            placed[i][start] = true;
            boolean isPlaced = placeVertically(crossWord, word, i, start + 1, end, index + 1, placed);
            if (isPlaced) return true;
            crossWord[i][start] = '-';
            placed[i][start] = false;
        }
        return false;
    }
}

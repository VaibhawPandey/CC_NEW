package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CombinationIterator {

    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("gkosu", 3);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.next());
    }
    Queue<String> queue;
    public CombinationIterator(String characters, int combinationLength) {

//        char arr[] = characters.toCharArray();
//        Arrays.sort(arr);
//
//        if (characters.equals(String.valueOf(arr))) {
        queue = new ArrayDeque<>();

        if (combinationLength == 1) {
            for (int i = 0; i < characters.length(); i++)
                queue.add(String.valueOf(characters.charAt(i)));
        } else {
            updateQueue(characters, 0, characters.length(), "", combinationLength);
        }
    }

    private void updateQueue(String characters, int index, int length, String text, int combinationLength) {

        if (text.length() == combinationLength) {
            queue.add(text);
            return;
        }

        if (index >= length)
            return;

        updateQueue(characters, index + 1, length, text + characters.charAt(index), combinationLength);

        updateQueue(characters, index + 1, length, text, combinationLength);
    }

    public String next() {

        if (!queue.isEmpty())
            return queue.poll();
        else
            return "";
    }

    public boolean hasNext() {
        if (queue.isEmpty())
            return false;

        return true;
    }
}

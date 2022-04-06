package main.java.Leetcode.MonthlyLC.LC2021.JulyLeetcodingChallenge.Week4;

public class TaskScheduler {

    // Alternative
    public int leastInterval(char[] tasks, int n) {

        int charCount[] = new int[26];
        int maxCharCount = Integer.MIN_VALUE, numberOfCharWithMaxCount = 0;

        for (char task: tasks) {
            charCount[task - 'A']++;
            if (charCount[task - 'A'] > maxCharCount) {
                maxCharCount = charCount[task - 'A'];
                numberOfCharWithMaxCount = 1;
            } else if (charCount[task - 'A'] == maxCharCount) {
                maxCharCount = charCount[task - 'A'];
                numberOfCharWithMaxCount++;
            }
        }

        return Math.max(tasks.length, (maxCharCount - 1) * (n + 1) + numberOfCharWithMaxCount);
    }

//    public int leastInterval(char[] tasks, int n) {
//
//        int charCount[] = new int[26];
//        int maxCharCount = Integer.MIN_VALUE, numberOfCharWithMaxCount = 0;
//
//        for (char task: tasks) {
//            charCount[task - 'A']++;
//            if (charCount[task - 'A'] > maxCharCount) {
//                maxCharCount = charCount[task - 'A'];
//                numberOfCharWithMaxCount = 1;
//            } else if (charCount[task - 'A'] == maxCharCount) {
//                maxCharCount = charCount[task - 'A'];
//                numberOfCharWithMaxCount++;
//            }
//        }
//
//        int slotInBetweenMaxChar = maxCharCount - 1;
//        int spaceInBetweenEachSlot = n - (numberOfCharWithMaxCount - 1);
//        int idleSpaceLeft = slotInBetweenMaxChar * spaceInBetweenEachSlot;
//        int availableElement = tasks.length - maxCharCount * numberOfCharWithMaxCount;
//        int totalIdleSpaceLeftAfterAssigning = Math.max(0, idleSpaceLeft - availableElement);
//
//        return tasks.length + totalIdleSpaceLeftAfterAssigning;
//    }
}

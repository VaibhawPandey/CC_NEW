package main.java.Leetcode.BiWeeklyContest.C31;

public class SubArrayWithOddSum {

    public int numOfSubarrays(int[] arr) {

        long oddNumbersCount = 0;
        long evenNumbersCount = 1;
        int val = 0;

        for (int i = 0; i < arr.length; i++) {
            val = (val + arr[i]) % 2;
            if (val != 0)
                oddNumbersCount++;
            else
                evenNumbersCount++;
        }

        return (int) ((oddNumbersCount * evenNumbersCount) % 1000000007);
    }
}

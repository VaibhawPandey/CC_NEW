package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week2;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {

        if (arr.length < 3)
            return false;

        int curr = arr[0];
        boolean isIncreasing = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == curr)
                return false;

            if (arr[i] > curr) {
                if (!isIncreasing)
                    return false;
            } else {
                if (i == 1)
                    return false;

                isIncreasing = false;
            }

            curr = arr[i];
        }

        return !isIncreasing;
    }
}

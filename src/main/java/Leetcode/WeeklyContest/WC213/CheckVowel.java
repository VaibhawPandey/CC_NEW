package main.java.Leetcode.WeeklyContest.WC213;

public class CheckVowel {
    public static void main(String[] args) {
        new CheckVowel().countVowelStrings(2);
    }
    public int countVowelStrings(int n) {

        int sum;
        int arr[] = new int[6];
        for (int i = 1; i < 6; i++)
            arr[i] = i;

        int c = 1;
        while (c++ < n) {
            int temp[] = new int[6];
            sum = arr[5];
            for (int i = 1; i <= 5; i++) {
                if (i == 1)
                    temp[i] = sum;
                else
                    temp[i] = temp[i-1] + (sum - arr[i - 1]);
            }

            for (int i = 1; i <= 5; i++)
                arr[i] = temp[i];
        }


        return arr[5];
    }
}

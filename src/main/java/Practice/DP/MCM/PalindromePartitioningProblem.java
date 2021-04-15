package main.java.Practice.DP.MCM;

import java.util.List;

public class PalindromePartitioningProblem {
    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningProblem().solve("nioik", 0, 5));
    }


    int solve(String s, int i, int j) {
        System.out.println(i +"--" + j);
        if (i >= j - 1 || isPalindrome(s.substring(i, j))) {
//            if (isPalindrome(s.substring(i, j)))
//            System.out.print(s.substring(i, j) +" ");
            return 0;
        }

        int tempAns = 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            tempAns = 1 + solve(s, i, k + 1) + solve(s, k + 1, j);
            min = Math.min(min, tempAns);
        }

        return min;
    }

    private boolean isPalindrome(String substring) {
        int i = 0, j = substring.length() - 1;
        while (i < j) {
            if (substring.charAt(i) != substring.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}

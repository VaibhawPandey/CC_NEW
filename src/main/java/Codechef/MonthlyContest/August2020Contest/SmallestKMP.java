package main.java.Codechef.MonthlyContest.August2020Contest;

import java.util.Scanner;

public class SmallestKMP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            String s1 = scanner.next();
            String s2 = scanner.next();

            int arr[] = new int[26];

            for (int j = 0; j < s1.length(); j++) {
                arr[s1.charAt(j) - 'a']++;
                if (j < s2.length())
                    arr[s2.charAt(j) - 'a']--;
            }

            StringBuilder res = new StringBuilder();

            for (int j = 0; j < 26; j++) {
                char nextChar = (char) ('a' + j);
                boolean tobeAddedBefore = false;

                if (s2 != null) {
                    if (s2.charAt(0) == nextChar) {
                        int k = 0;
                        while (s2.charAt(k) == nextChar && k < s2.length())
                            k++;

                        if (s2.charAt(k) < nextChar)
                            tobeAddedBefore = true;
                    }

                    if (s2.charAt(0) == nextChar && tobeAddedBefore) {
                        res.append(s2);
                        s2 = null;
                    }
                }


                while (arr[j] > 0) {
                    res.append(nextChar);
                    arr[j]--;
                }

                if (s2 != null && s2.charAt(0) == nextChar && !tobeAddedBefore) {
                    res.append(s2);
                    s2 = null;
                }
            }

            System.out.println(res.toString());
        }
    }
}

package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week2;

import main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week2.CombinationIterator;

public class CompareVersion {

    public static void main(String[] args) {
        new CompareVersion().compareVersion("0.1", "1.1");
    }
    public int compareVersion(String version1, String version2) {

        String versionSet1[] = version1.split("\\.");
        String versionSet2[] = version2.split("\\.");

        return getVersionCompare(versionSet1, versionSet2, versionSet1.length, versionSet2.length);
    }

    private int getVersionCompare(String[] versionSet1, String[] versionSet2, int m, int n) {

        int i = 0, j = 0;

        while (i < m && j < n) {
            int k = Integer.parseInt(versionSet1[i]), l = Integer.parseInt(versionSet2[j]);
            if (k > l)
                return 1;
            else if (k < l)
                  return -1;
        }

        while (i < m) {
            if (Integer.parseInt(versionSet1[i]) != 0)
                return 1;
        }

        while (j < n) {
            if (Integer.parseInt(versionSet2[j]) != 0)
                return -1;
        }

        return 0;
    }
}

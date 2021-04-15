package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week3;

public class MirrorReflection {
    public int mirrorReflection(int p, int q) {

        while (p%2 == 0 && q%2 == 0) {
            p /= 2;
            q /= 2;
        }

        if (p%2 != 0 && q%2 != 0) return 1;
        if (p%2 != 0 && q%2 == 0) return 0;
        if (p % 2 == 0 && q % 2 != 0) return 2;

        return -1;
    }
}

package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week1;

public class ConsecutiveCharacter {
    public int maxPower(String s) {

        char charArr[] = s.toCharArray();

        if (charArr.length == 0)
            return 0;

        int res = 0;
        char lastChar = charArr[0];
        int temp = 1;

        for (int i = 1; i < charArr.length; i++) {

            if (lastChar == charArr[i])
                continue;

            res = Math.max(res, temp);
            temp = 1;
            lastChar = charArr[i];
        }

        return res;
    }
}

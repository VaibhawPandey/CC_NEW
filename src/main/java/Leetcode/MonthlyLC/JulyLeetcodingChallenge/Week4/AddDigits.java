package main.java.Leetcode.MonthlyLC.JulyLeetcodingChallenge.Week4;

public class AddDigits {

    public int addDigits(int num) {

        if (num % 9 == 0)
            return 0;

        return (num % 9 == 0)?  9: num % 9;
    }
}

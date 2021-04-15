package main.java.Leetcode.WeeklyContest.WC220;

public class ReformatPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new ReformatPhoneNumber().reformatNumber("123 4-5678"));
    }
    public String reformatNumber(String number) {

        String num = "";
        for (int i = 0; i < number.length(); i++)
            if (number.charAt(i) != ' ' && number.charAt(i) != '-')
                num += number.charAt(i);

        String res = "";
        int n = num.length();
        for (int i = 0; i < n;) {
            if (n - i > 4) {
                res += num.substring(i, i + 3) +'-';
                i += 3;
            } else if (n-i == 4) {
                res += num.substring(i, i + 2) + '-' + num.substring(i+2, i + 4);
                break;
            } else if (n-i == 3) {
                res += num.substring(i, i + 3);
                break;
            } else if (n-i == 2) {
                res += num.substring(i, i + 2);
                break;
            }
        }


        return res;
    }
}

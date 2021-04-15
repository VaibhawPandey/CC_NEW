package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week3;

public class DecodingString {
    public static void main(String[] args) {
        System.out.println(new DecodingString().decodeAtIndex("y959q969u3hb22odq595", 222280369));
    }
    public String decodeAtIndex(String S, int K) {
        StringBuilder temp = new StringBuilder();
        int index = 0;
        String res = "";

        while (K > 0 && index < S.length()) {
            int diff = S.charAt(index) - 'a';
            if (diff >= 0 && diff < 26) {
                temp.append(S.charAt(index));
            } else {
                int d = (S.charAt(index) - '0') - 1;
                int strLen = temp.length();
                if (strLen * d >= K) {
                    int pos = K % strLen;
                    res = String.valueOf(temp.charAt(pos));
                    break;
                }
                else
                    K -= (strLen * d);
            }

            index++;
        }

        if (res == "") {
            int strLen = temp.length();
            int pos = K % strLen;
            res = String.valueOf(temp.charAt(pos));
        }

        return res;
    }
}

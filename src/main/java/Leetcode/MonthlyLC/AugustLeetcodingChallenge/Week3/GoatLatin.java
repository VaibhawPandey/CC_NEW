package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week3;



public class GoatLatin {
    public String toGoatLatin(String S) {

        String words[] = S.split(" ");
        char vowelList[] = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        String aCount = "a";

        for (int i = 0; i < words.length; i++) {

            String temp = words[i];
            if (isVowel(temp.charAt(0), vowelList))
                temp += "ma" +aCount;
            else {
                temp = words[i].substring(1) + words[i].charAt(0);
                temp += "ma" +aCount;
            }
            aCount += "a";
            words[i] = temp;
        }

        S = "";
        for (int i = 0; i < words.length - 1; i++) {
            S += words[i] + " ";
        }

        S += words[words.length - 1];



        return S;
    }

    private boolean isVowel(char firstChar, char[] vowelList) {

        for (char vowel: vowelList)
            if (firstChar == vowel)
                return true;

        return false;
    }
}

package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week2;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public int longestPalindrome(String s) {

        int arr[] = new int[52];
        int res = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (arr[c - 'a'] > 0) {
                    arr[c - 'a']--;
                    res += 2;
                    continue;
                }
                arr[c - 'a']++;
            } else {
                if (arr[c - 'A' + 26] > 0) {
                    arr[c - 'A' + 26]--;
                    res += 2;
                    continue;
                }
                arr[c - 'A' + 26]++;
            }
        }

        for (int i = 0; i < 52; i++) {
            if (arr[i] == 1) {
                res += 1;
                break;
            }
        }



        return res;
    }
}

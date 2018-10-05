package DP;

/**
 * Created by YANGSONG on 2018-09-28.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"

 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }

        boolean[][] f = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            f[i][i] = true;
        }

        int max = 0;
        int[] indices = new int[2];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                // f[i + 1][j - 1] something likes:
                // b aba d
                // i     j : f[i + 1][j - 1] means if f[s.substring(i+1, j-1+1)] //"aba" is a palindrome
                f[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || f[i + 1][j - 1] == true);

                if (f[i][j] == true) {
                    max = Math.max(max, j - i + 1);
                    if (max == j - i + 1) {
                        indices[0] = i;
                        indices[1] = j;
                    }
                }

            }
        }
        return s.substring(indices[0], indices[1] + 1);

    }
}

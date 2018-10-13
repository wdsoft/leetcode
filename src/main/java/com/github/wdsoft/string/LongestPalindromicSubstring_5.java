package com.github.wdsoft.string;

/**
 * 最长回文子串
 */

/**
 * 普通解法，设置两个索引逐渐外扩，注意要区分相邻两个字符是否相等情况
 * 时间复杂度O(n^2)
 */
/*public class LongestPalindromicSubstring_5 {
    int maxLen = 0, index = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int left = 0, right = s.length() - 1;
        for (int i = 0; i < s.length()-1; i++) {
            //第一种情况，以某个字符向外扩
            extendPalindrome(s, i, i);
            //第二种情况，以某两个相邻字符向外扩
            extendPalindrome(s, i, i + 1);
        }

        return s.substring(index, index + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            maxLen = right - left - 1;
            index = left + 1;
        }
    }
}*/

/**
 * Manacher算法，时间复杂度O(n), 空间复杂度O(n)
 */
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String str = preProcess(s);
        int maxIndex = 0, idx = 0, length = str.length();
        int[] p = new int[length];
        for (int i = 1; i < length - 1; i++) {
            p[i] = maxIndex > i ? Math.min(p[2 * idx - i], maxIndex - i) : 1;
            while (str.charAt(i + p[i]) == str.charAt(i - p[i])) {
                p[i]++;
            }

            if (maxIndex < i + p[i]) {
                maxIndex = i + p[i];
                idx = i;
            }
        }

        int maxLen = 0, startIndex = 0;
        for (int i = 0; i < length; i++) {
            if (maxLen < p[i]) {
                maxLen = p[i];
                startIndex = i;
            }
        }

        return s.substring((startIndex - maxLen) / 2, (startIndex - maxLen) / 2 + maxLen - 1);
    }

    private String preProcess(String s) {
        StringBuffer sb = new StringBuffer();
        sb.append("$");
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");
        sb.append("^");

        return sb.toString();
    }
}
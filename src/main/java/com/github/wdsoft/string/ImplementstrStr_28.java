package com.github.wdsoft.string;

public class ImplementstrStr_28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null || needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j >= haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

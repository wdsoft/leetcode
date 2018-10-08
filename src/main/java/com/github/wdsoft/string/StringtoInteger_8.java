package com.github.wdsoft.string;

public class StringtoInteger_8 {
    public int myAtoi(String str) {
        int num = 0;
        int sign = 1;
        int index = 0;
        int MIN_VALUE = -2147483648;
        int MAX_VALUE = 2147483647;
        int length = str.length();

        for (; index < length && str.charAt(index) == ' '; index++);

        if (index < length && str.charAt(index) == '+') {
            index++;
        }else if (index < length && str.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        for (; index < length; index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }

            if (num > MAX_VALUE / 10 ||
                    (num == MAX_VALUE / 10 && (str.charAt(index) - '0') > MAX_VALUE % 10)) {
                return sign == -1 ? MIN_VALUE : MAX_VALUE;
            }

            num = num * 10 + str.charAt(index) - '0';
        }

        return num * sign;
    }
}

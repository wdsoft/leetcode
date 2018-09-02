package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/9/2.
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int[] result;
        int num = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += num;
            num = digits[i] / 10;
            digits[i] %= 10;
        }

        int index = 0;
        if (num == 0) {
            result = new int[digits.length];
        } else {
            result = new int[digits.length + 1];
            index++;
            result[0] = num;
        }

        for (int i = 0; i < digits.length; i++) {
            result[index++] = digits[i];
        }

        return result;
    }
}

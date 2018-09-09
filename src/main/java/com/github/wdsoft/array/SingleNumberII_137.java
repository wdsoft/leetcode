package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/9/9.
 */
public class SingleNumberII_137 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            b = b ^ nums[i] & ~a;
            a = a ^ nums[i] & ~b;
        }

        return a | b;
    }
}

package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/9/9.
 */
public class SingleNumber_136 {
    //运用异或运算规则
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x ^= nums[i];
        }

        return x;
    }
}

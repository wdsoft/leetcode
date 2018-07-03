package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/7/3.
 */
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}

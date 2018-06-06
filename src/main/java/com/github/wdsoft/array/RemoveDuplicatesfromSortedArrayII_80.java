package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/6/6.
 */
public class RemoveDuplicatesfromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 0;
        int numCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
                numCount = 1;
            } else if (nums[index] == nums[i] && numCount < 2) {
                nums[++index] = nums[i];
                numCount++;
            } else {
                continue;
            }
        }

        return index + 1;
    }
}

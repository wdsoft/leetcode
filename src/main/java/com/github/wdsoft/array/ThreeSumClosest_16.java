package com.github.wdsoft.array;

import java.util.Arrays;

/**
 * Created by jwd on 2018/6/26.
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }

        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(sum - target) < gap) {
                    result = sum;
                    gap = Math.abs(sum - target);
                }

                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }

        return result;
    }
}

package com.github.wdsoft.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jwd on 2018/6/25.
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 相同数字已经找过解决方案了，所以跳过
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] > target) {
                    high--;
                } else if (nums[i] + nums[low] + nums[high] < target) {
                    low++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // 过滤掉已在解决方案中的相同数字的情形，防止相同方案的出现
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                }
            }
        }

        return result;
    }
}

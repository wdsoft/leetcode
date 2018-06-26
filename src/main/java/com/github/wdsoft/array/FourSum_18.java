package com.github.wdsoft.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jwd on 2018/6/26.
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a-1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b-1]) {
                    continue;
                }
                int c = b + 1;
                int d = nums.length - 1;

                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
                        c++;
                    } else {
                        result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        // 过滤掉已在解决方案中的相同数字的情形，防止相同方案的出现
                        while (c < d && nums[c] == nums[c + 1]) c++;
                        while (c < d && nums[d] == nums[d - 1]) d--;
                        c++;
                        d--;
                    }
                }
            }
        }

        return result;
    }
}

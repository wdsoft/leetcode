package com.github.wdsoft.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jwd on 2018/7/4.
 */
public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), new boolean[nums.length], result);
        return result;
    }

    // 回溯
    public void dfs(int[] nums, List<Integer> list, boolean[] used, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            // 当前元素与其前一个元素值相同 且 前元素未被加到list中，跳过该元素
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                dfs(nums, list, used, result);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}

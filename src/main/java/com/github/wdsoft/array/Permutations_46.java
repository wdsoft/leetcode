package com.github.wdsoft.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwd on 2018/7/4.
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        dfs(nums, 0, result);
        return result;
    }

    // 深度搜索
    public void dfs(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num: nums) {
                list.add(num);
            }
            result.add(list);
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, index+1, result);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 回溯
    public void dfs(int[] nums, List<Integer> list, boolean[] used, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }

        for (int i = 0; i < nums.length; i++) {
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

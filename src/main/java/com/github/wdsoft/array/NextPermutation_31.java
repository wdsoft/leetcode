package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/7/3.
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int i, j, k;
        for (i = nums.length - 2; i >= 0; i--) {
            j = i + 1;
            //step1：找到第一个相邻元素对(i, j)，nums[i] < nums[j]
            if (nums[i] >= nums[j]) {
                continue;
            }
            //step2：在[j, end)中，找到最小的nums[k]，使得nums[i] < nums[k]，之后交换二者位置
            for (k = nums.length - 1; nums[i] >= nums[k]; k--);
            swap(nums, i, k);
            //step3：逆置[j, end)之间的数，由于[j, end)为降序，所以逆置后为下一排列的最小值
            reverse(nums, j, nums.length - 1);
            return;
        }

        //step4：若在step1中没有找到相邻元素对，则表明当前数组整体为降序，为最大值，此时下一个序列为当前数组的逆置
        reverse(nums, 0, nums.length - 1);
    }

    public void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public void reverse(int[] nums, int low, int high) {
        for (int i = 0; i <= (high - low) / 2; i++) {
            int temp = nums[low + i];
            nums[low + i] = nums[high - i];
            nums[high - i] = temp;
        }
    }
}

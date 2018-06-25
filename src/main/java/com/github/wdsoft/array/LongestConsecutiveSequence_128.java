package com.github.wdsoft.array;

import sun.nio.cs.ext.MacThai;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jwd on 2018/6/24.
 */
public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();
        for (int num: nums) {
            used.put(num, false);
        }

        int longest = 0;
        for (int num: nums) {
            if (used.get(num)) {
                continue;
            }

            int length = 1;
            used.put(num, true);
            for (int bigNum = num + 1; used.containsKey(bigNum); bigNum++) {
                used.put(bigNum, true);
                length++;
            }
            for (int smallNum = num - 1; used.containsKey(smallNum); smallNum--) {
                used.put(smallNum, true);
                length++;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }
}

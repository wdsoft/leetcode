package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/7/14.
 */
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
            maxRight[n-1-i] = Math.max(maxRight[n-i], height[n-i]);
        }

        int sum = 0;
        int distance = 0;
        for (int i = 0; i < n; i++) {
            distance = Math.min(maxLeft[i], maxRight[i]);
            if (distance > height[i]) {
                sum += distance - height[i];
            }
        }

        return sum;
    }
}

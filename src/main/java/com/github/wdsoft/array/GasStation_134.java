package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/9/3.
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int left = 0;
        int total = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            left += gas[i] - cost[i];
            total += gas[i] - cost[i];
            // 若当前站点的累计剩余油量变为了负数，则需要之前的所有站点都不能作为起始点
            // 需要从下一个站点重新开始
            if (left < 0) {
                index = i + 1;
                left = 0;
            }
        }

        if (total >= 0) {
            return index;
        } else {
            return -1;
        }
    }
}

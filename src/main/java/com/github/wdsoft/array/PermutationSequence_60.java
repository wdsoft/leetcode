package com.github.wdsoft.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwd on 2018/7/4.
 */
public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        if (n <= 0) {
            return "";
        }

        // 康托编码
        k--;
        StringBuffer sb = new StringBuffer();
        int factorial = 1;
        List<Integer> nums = new ArrayList<>();
        // 计算(n-1)!
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        for (int i = n-1; i >= 0; i--) {
            int index = k / factorial;
            sb.append(nums.get(index));
            nums.remove(index);
            k %= factorial;
            if (i > 0) {
                factorial /= i;
            }
        }

        return sb.toString();
    }
}

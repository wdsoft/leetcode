package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/9/3.
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int sum = 0;

        candy[0] = 1;
        //先从左往右，若右面的比左面的级别高，则糖果数为左面数量+1
        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i] < ratings[i+1]) {
                candy[i+1] = candy[i] + 1;
            } else {
                candy[i+1] = 1;
            }
        }
        //再从右往左，若左面的级别比右面高，则更新左面数量为右面数量+1
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
                candy[i] = candy[i+1] + 1;
            }
        }

        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }

        return sum;
    }
}

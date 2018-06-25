package com.github.wdsoft.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jwd on 2018/6/14.
 */
public class MedianofTwoSortedArraysTest_4 {
    @Test
    public void testMedianofTwoSortedArrays() {
        int[] num1 = {4};
        int[] num2 = {1,2,3,5,6};
        MedianofTwoSortedArrays_4 obj = new MedianofTwoSortedArrays_4();
        System.out.print(obj.findMedianSortedArrays(num1, num2));
    }
}

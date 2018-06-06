package com.github.wdsoft.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jwd on 2018/6/6.
 */
public class RemoveDuplicatesfromSortedArrayTest_26 {
    int[] nums;

    @Before
    public void buildNums() {
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
    }

    @Test
    public void testRemoveDuplicates() {
        RemoveDuplicatesfromSortedArray_26 obj = new RemoveDuplicatesfromSortedArray_26();
        Assert.assertEquals(5, obj.removeDuplicates(nums));
    }
}

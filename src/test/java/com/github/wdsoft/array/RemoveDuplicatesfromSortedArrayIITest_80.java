package com.github.wdsoft.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jwd on 2018/6/6.
 */
public class RemoveDuplicatesfromSortedArrayIITest_80 {
    @Test
    public void testRemoveDuplicates() {
        int[] nums = new int[]{1,1,1,2,2,3};
        RemoveDuplicatesfromSortedArrayII_80 obj = new RemoveDuplicatesfromSortedArrayII_80();
        Assert.assertEquals(5, obj.removeDuplicates(nums));
    }
}

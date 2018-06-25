package com.github.wdsoft.array;

/**
 * Created by jwd on 2018/6/14.
 */
public class MedianofTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalCount = nums1.length + nums2.length;
        if (totalCount % 2 != 0) {
            return findKth(nums1, nums1.length, nums2, nums2.length, totalCount / 2 + 1);
        } else {
            return (findKth(nums1, nums1.length, nums2, nums2.length, totalCount / 2)
            + findKth(nums1, nums1.length, nums2, nums2.length, totalCount / 2 + 1)) / 2.0;
        }
    }

    public double findKth(int[] num1, int length1, int[] num2, int length2, int k) {
        if (length1 > length2) {
            return findKth(num2, length2, num1, length1, k);
        }
        if (length1 == 0) {
            return num2[k-1];
        }
        if (k == 1) {
            return Math.min(num1[0], num2[0]);
        }

        int index1 = Math.min(k / 2, length1);
        int index2 = k - index1;
        if (num1[index1 - 1] < num2[index2 - 1]) {
            return findKth(num1, length1 - index1,  num2, length2, k - index1);
        } else if (num1[index1 - 1] > num2[index2 - 1]) {
            return findKth(num1, length1,  num2, length2 - index2, k - index2);
        } else {
            return num1[index1 - 1];
        }
    }
}

package com.fish.lab.leetcode;

/**
 * 找出数组中的众数
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        if(nums == null) {
            return -1;
        }
        int count = 0;
        Integer candidate = null;
        for (int num:nums) {
            if(count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}

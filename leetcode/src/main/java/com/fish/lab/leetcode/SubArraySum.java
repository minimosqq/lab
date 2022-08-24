package com.fish.lab.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 和为k的连续子序列个数
 */
public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        //key为前缀和，value为个数
        sumMap.put(0, 1);
        for (int i=0; i<nums.length; i++) {
            pre += nums[i];
            if (sumMap.containsKey(pre-k)) {
                count += sumMap.get(pre-k);
            }
            sumMap.put(pre, sumMap.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}

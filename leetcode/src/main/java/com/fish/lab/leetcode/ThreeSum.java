package com.fish.lab.leetcode;

import java.util.*;


public class ThreeSum{
    public static List<int[]> tupleSum(int[] nums) {
        if(nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i<nums.length-2) {
            if ((i>=1) && (nums[i] == nums[i-1])) {
                i++;
                continue;
            }
            int j = i+1, k = nums.length-1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    int[] temp = new int[]{i,j,k};
                    res.add(temp);
                    j++;
                    while(nums[j] == nums[j-1]) {
                        j++;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    while(nums[j] == nums[j-1]) {
                        j++;
                    }
                } else {
                    k--;
                    while(nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }
            i++;
        }
        return res;
    }
    public static void main (String[] args) {
        int[] a = new int[]{-1,0,1,2,-1,-4};
        List<int[]> result = tupleSum(a);
        for(int[] tuple : result) {
            for(int i = 0; i < 3; i++) {
                System.out.println(a[tuple[i]]);
            }
        }
    }

}
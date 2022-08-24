package com.fish.lab.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长连续序列
 */
class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                continue;
            }
            int left = indexMap.getOrDefault(nums[i] - 1, 0);
            int right = indexMap.getOrDefault(nums[i] + 1, 0);

            //计算此刻经过当前位置的连续序列总长度
            int curLength = 1 + left + right;

            if (curLength > maxLength) {
                maxLength = curLength;
            }
//            indexMap.put(nums[i], curLength);

            //有点动态规划的意思，每个位置的最长序列只依赖本序列的最左或最右边界，所以核心就是要找到这两个位置并更新它们！

            //持续拓展最左边界
            indexMap.put(nums[i] - 1 - left + 1, curLength);
            //持续拓展最右边界
            indexMap.put(nums[i] + 1 + right - 1, curLength);

        }
        return maxLength;
    }


    public static int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        ///直接去重
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            //我们的遍历方式是从当前的num持续向后探测num+1,num+2....num+x，获得num之后的最大长度；
            //对于num-1存在的情况，此时不需要关注，因为它肯定不如真正遍历到num-1时所获取的长度。
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        longestConsecutive(nums);
    }
}
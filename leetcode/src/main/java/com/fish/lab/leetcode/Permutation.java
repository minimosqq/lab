package com.fish.lab.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> path, boolean[] used) {
        // 判断：结束条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果使用过了，则直接跳过
            if (used[i]) {
                continue;
            }
            // 先序：首次进入节点，添加到「路径」中
            path.add(nums[i]);
            // 标记使用
            used[i] = true;
            // 递归
            backtrack(nums, path, used);
            // 后续：即将离开节点，从「路径」中除去
            path.remove(path.size() - 1);
            // 取消标记
            used[i] = false;
        }
    }
}

package com.fish.lab.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class ParenthesisGenerator {

    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrace(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    private void backtrace(List<String> res, StringBuilder sb, int leftCount, int rightCount, int count) {
        if (sb.length() == 2 * count) {
            res.add(sb.toString());
            return;
        }
        if(leftCount < count) {
            sb.append('(');
            backtrace(res, sb, leftCount+1, rightCount, count);
            sb.deleteCharAt(sb.length()-1);
        }
        if(rightCount<leftCount) {
            sb.append(')');
            backtrace(res, sb, leftCount, rightCount +1, count);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
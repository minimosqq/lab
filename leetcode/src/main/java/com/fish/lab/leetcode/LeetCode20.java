package com.fish.lab.leetcode;

import java.util.Scanner;
import java.util.Stack;

public class LeetCode20 {

    public static boolean isValid(String s) {
        Stack<Character> charStack = new Stack<Character>();
        char[] charArray = s.toCharArray();

        for(int i = 0; i < charArray.length; i++) {
            if(i == '(' || i == '[' || i == '{') {
                charStack.push(charArray[i]);
            } else {
                if(charStack.isEmpty() || !isMatch(charStack.peek(), charArray[i])) {
                    return false;
                }
                charStack.pop();
            }
        }
        return charStack.isEmpty();
    }

    private static boolean isMatch(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = null;
        while (true) {
            s = getLine();
            isValid(s);
        }
    }

    private static String getLine() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

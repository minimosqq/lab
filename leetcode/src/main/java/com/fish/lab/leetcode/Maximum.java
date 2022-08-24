package com.fish.lab.leetcode;

import java.util.LinkedList;

public class Maximum {

    public static int[] slideWindowMax(int [] arr, int k) {
        LinkedList<Integer> win = new LinkedList<>();
        int[] res = new int[arr.length-k+1];
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < k-1) {
                if (win.isEmpty() || win.getLast() > arr[i]) {
                    win.add(arr[i]);
                } else {
                    while (!win.isEmpty() && arr[i] > win.getLast()) {
                        win.removeLast();
                    }
                    if (win.isEmpty()) {
                        maxIndex = i;
                    }
                    win.add(arr[i]);
                }
            } else {
                if (i-maxIndex >= k) {
                    win.removeFirst();
                }
                if (win.isEmpty() || win.getLast() > arr[i]) {
                    if (win.isEmpty()) {
                        maxIndex = i;
                    }
                    win.add(arr[i]);
                } else {
                    while (!win.isEmpty() && arr[i] > win.getLast()) {
                        win.removeLast();
                    }
                    if (win.isEmpty()) {
                        maxIndex = i;
                    }
                    win.add(arr[i]);
                }
                res[i - k + 1] = win.getFirst();

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = slideWindowMax(a, 3);
        for (int i = 0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }

}

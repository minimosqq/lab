package com.fish.lab.leetcode;

import java.util.PriorityQueue;

/**
 * 数据流的中位数（二维堆）
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        //优先队列默认堆顶是最小值
        minHeap = new PriorityQueue<>();
        //lambda的写法，构造大顶堆！lambda yyds！
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        //如果当前所有元素个数为偶数:先加入小顶堆，调整之后再将小顶堆的堆顶加入到大顶堆——这样调整后大顶堆的元素个数最多比小顶堆多一个，最终输出中位数的时候输出大顶堆的堆顶即可
        if(minHeap.size() == maxHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else{//如果当前所有元素个数为奇数：先加入大顶堆，调整后再将大顶堆的堆顶加入小顶堆
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek())/2.0;
        else
            return maxHeap.peek();
    }
}

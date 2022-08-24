package com.fish.lab.interview;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    public class DNode{
        int val;
        DNode prev;
        DNode next;
        public DNode(int val) {
            this.val = val;
        }
        public DNode() {
        }
    }
    private int capacity;
    private int size;
    private DNode head, tail;
    private Map<Integer, Integer> cache;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            move2Head(key);
        }
        return cache.get(key);
    }


    public void set(int key, int val) {
        if (cache.containsKey(key)) {
            move2Head(key);
        } else {
            add2Head(key);
        }
        cache.put(key, val);
    }

    private void add2Head(int key) {
        size++;
        if (this.size == this.capacity) {
            removeTail();
        }
        DNode node = new DNode(key);
        head.next = node;
    }

    private void removeTail() {
        if (size != 0) {
            tail = tail.next;
            size--;
        }
    }

    private void move2Head(int key) {
        DNode temp = tail;
        DNode prev = new DNode();
        prev.next = temp;
        while(temp != head) {
            if (temp.val != key) {
                temp = temp.next;
                prev = prev.next;
            } else {
                break;
            }
        }
        prev.next = temp.next;
        temp.next = null;
        head.next = temp;
    }

}

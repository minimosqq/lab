package com.fish.lab.interview;

public class Queue {
    String[] elements;
    int head;
    int tail;
    int size;

    public Queue(int size) {
        this.size = size;
        elements = new String[size];
        head = 0;
        tail = 0;
    }

    public void enQueue(String str) {
        if (head < size - 1) {
            elements[head] = str;
            head++;
        } else {
            String[] newEle = new String[size*2];

            for (int i=0; i<elements.length; i++) {
                newEle[i] = elements[i];
                head = i;
            }
            elements = newEle;
            elements[head] = str;
        }
    }

    public String deQueue() {
        if (tail < head) {
            return elements[tail++];
        }
        return "";
    }
}

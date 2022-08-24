package com.fish.lab.leetcode;

import java.util.Arrays;

public class CircleArrayQueue {
    public class CircularQueueTeacher<T> {
        //属性
        private int front;//队头指针
        private int rear;//队尾指针
        private int maxSize;//队列最大容量
        private Object[] queue;//队列数组

        //空参构造器
        public CircularQueueTeacher() {
            this.maxSize = 16;
        }

        //指定容量构造器
        public CircularQueueTeacher(int maxSize) {
            this();
            this.maxSize = maxSize;
        }

        //获取队列数据个数
        public int getSize() {
            return (rear + maxSize - front) % maxSize;
        }

        //添加数据
        public void add(T t) {
            //懒汉式：要添加数据了才创建数组
            if (queue == null) {
                queue = new Object[maxSize];
            }
            //判断队列是否已满
            if ((rear + 1) % maxSize == front) {
                throw new RuntimeException("队列已满");
            }
            //真正添加数据的操作
            queue[rear] = t;
            //边界条件，确保rear在数组范围内，并实现环形移动
            rear = (rear + 1) % maxSize;
        }

        //弹出数据
        public T pop() {
            //判断队列是否为空
            if (rear == front) {
                throw new RuntimeException("队列为空");
            }
            //真正弹出数据的操作
            T t = (T) queue[front];
            //将弹出位置置为空
            queue[front] = null;
            //边界条件，确保front在数组范围内，并实现环形移动
            front = (front + 1) % maxSize;
            //返回弹出数据
            return t;
        }

        //重写toString()方法

        @Override
        public String toString() {
            return "CircularQueueTeacher{" +
                    "queue=" + Arrays.toString(queue) +
                    '}';
        }
    }

}

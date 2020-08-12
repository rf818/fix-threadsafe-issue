package com.github.hcsp.multithread;

// 一、synchronized

//public class Counter {
//    private int value = 0;
//
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public synchronized int addAndGet(int i) {
//        value += i;
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public synchronized int minusAndGet(int i) {
//        value -= i;
//        return value;
//    }
//}

// 二、AtomicInteger

//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Counter {
//    private final AtomicInteger value = new AtomicInteger(0);
//
//    public int getValue() {
//        return value.get();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        value.addAndGet(i);
//        return value.get();
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        value.addAndGet(-i);
//        return value.get();
//    }
//}

// 三、ReentrantLock

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    ReentrantLock lock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        lock.lock();
        try {
            value += i;
        } finally {
            lock.unlock();
        }
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        lock.lock();
        try {
            value -= i;
        } finally {
            lock.unlock();
        }
        return value;
    }
}

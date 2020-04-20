package com.github.hcsp.multithread;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    private Object lock = new Object();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        synchronized (lock) {
            value += i;
        }
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        synchronized (lock) {
            value -= i;
        }
        return value;
    }
}

class Counter1 {
    AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.intValue();
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        return value.getAndAdd(i);
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        return value.getAndAdd(-i);
    }
}

class Counter2 {
    ReentrantLock lock = new ReentrantLock();
    private int value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        lock.lock();
        value += i;
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        try {
            value -= i;
        } finally {
            lock.unlock();
        }
        return value;
    }
}

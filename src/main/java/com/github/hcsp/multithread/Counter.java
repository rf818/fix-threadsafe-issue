package com.github.hcsp.multithread;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        reentrantLock.lock();
        try {
            value += i;
            return value;
        } finally {
            reentrantLock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized int minusAndGet(int i) {
        reentrantLock.lock();
        try {
            value -= i;
            return value;
        } finally {
            reentrantLock.unlock();
        }
    }
}

package com.github.hcsp.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Counter {
    private int value = 0;

    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();


    public int getValue() {
        readLock.lock();
        try {
            return value;
        } finally {
            readLock.unlock();
        }

    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        writeLock.lock();
        try {
            value += i;
            return value;
        } finally {
            writeLock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        writeLock.lock();
        try {
            value -= i;
            return value;
        } finally {
            writeLock.unlock();
        }
    }
}

package com.github.hcsp.multithread;

//import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    // private AtomicInteger value = new AtomicInteger();
    private int value = 0;
    private Lock lock = new ReentrantLock();

    public int getValue() {
        return value;
        // return value.get();
    }

    // 加上一个整数i，并返回加之后的结果
    int addAndGet(int i) {
        //value += i;
        lock.lock();
        try {
            value += i;
            return value;
        } finally {
            lock.unlock();
        }

        //  return value;

        //return value.addAndGet(i);
    }

    // 减去一个整数i，并返回减之后的结果
    synchronized int minusAndGet(int i) {
        lock.lock();
        try {
            value -= i;
            return value;
        } finally {
            lock.unlock();
        }
        //value -= i;

        //return value.addAndGet(-i);
    }
}

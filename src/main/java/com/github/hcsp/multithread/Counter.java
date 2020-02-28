package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    /*我们有一个在多线程环境下不安全的Counter类，请将它改写为线程安全的。

    我们鼓励你使用多种方法：

    synchronized方法
    java.util.concurrent.locks.Lock
    AtomicInteger
    祝你好运！*/
    private static AtomicInteger value = new AtomicInteger(0);
    private int valueForLockTest = 0;

    private final ReentrantLock lock = new ReentrantLock();

    public int getValue() {
        return value.get();
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        return value.addAndGet(i);
    }

    public int addAndGetWithLock(int i) {
        lock.lock();  // block until condition holds
        try {
            valueForLockTest += i;
            return valueForLockTest;
        } finally {
            lock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        return value.addAndGet(-i);
    }

}

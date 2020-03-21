package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    private ReentrantLock lock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        lock.lock();
        value += i;
        lock.unlock();
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        lock.lock();
        value -= i;
        lock.unlock();
        return value;
    }
}

class Counter2 {
    private int value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public synchronized int addAndGet(int i) {
        value += i;
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized int minusAndGet(int i) {
        value -= i;
        return value;
    }
}

class Counter3 {
    private AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.intValue();
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        value.addAndGet(i);
        return value.intValue();
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        value.addAndGet(-i);
        return value.intValue();
    }
}

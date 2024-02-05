package com.github.hcsp.multithread;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;
    ReentrantLock reentrantLock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public void addAndGet(int i) {
        //采用synchronized方法
        reentrantLock.lock();
        try {
            value += i;
        } finally {
            reentrantLock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public void minusAndGet(int i) {
        reentrantLock.lock();
        try {
            value -= i;
        } finally {
            reentrantLock.unlock();
        }
    }
}

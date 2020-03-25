package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    //第三种方法AtomicInteger
    private AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.get();
    }
    /*private int value = 0;

    public int getValue() {
        return value;
    }*/
    //第一种方法synchronized
    // 加上一个整数i，并返回加之后的结果
    /*public synchronized int addAndGet(int i) {
        value += i;
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public synchronized int minusAndGet(int i) {
        value -= i;
        return value;
    }*/

    //第二种方法lock
   /* private Lock lock = new ReentrantLock();

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
    }*/
    public int addAndGet(int i) {
        return value.addAndGet(1);
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        return value.addAndGet(-1);
    }
}

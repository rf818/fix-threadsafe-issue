package com.github.hcsp.multithread;

//import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    //    private final Object lock = new Object();
//    private AtomicInteger value = new AtomicInteger(0);
    private final Lock lock = new ReentrantLock();
    private int value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        synchronized (lock) {
//            value += i;
//        }
//        return value;
//    }

    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        synchronized (lock) {
//            value -= i;
//        }
//        System.out.println(value);
//        return value;
//    }
//
//    public AtomicInteger addAndGet(int i) {
//        value.getAndAdd(i);
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public AtomicInteger minusAndGet(int i) {
//        value.getAndAdd(- i);
//        System.out.println(value);
//        return value;
//    }

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
        System.out.println(value);
        return value;
    }
}

package com.github.hcsp.multithread;

//import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private ReentrantLock lock = new ReentrantLock();
    private int value = 0;


    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        try {
            lock.lock();
            value += i;

        } finally {
            lock.unlock();
        }
        return value;
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        try {
            lock.lock();
            value -= i;

        } finally {
            lock.unlock();
        }
        return value;

    }
//    private Object lock = new Object();
//    private AtomicInteger value = new AtomicInteger(0);
//
//
//    public int getValue() {
//        return value.intValue();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//
//        return value.addAndGet(i);
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//
//        return value.addAndGet(-i);
//    }
//    private int value = 0;
//    private Object lock = new Object();
//
//
//    public int getValue() {
//        return value;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public int addAndGet(int i) {
//        synchronized (lock) {
//            value += i;
//        }
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        synchronized (lock) {
//            value -= i;
//        }
//        return value;
//    }
}

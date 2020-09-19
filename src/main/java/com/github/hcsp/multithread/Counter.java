package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    //  method 3: AtomicInteger
    public AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.get();
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        return value.addAndGet(1);
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        return value.decrementAndGet();
    }

//  method 1： synchronized
//    public synchronized int addAndGet(int i) {
//        value += i;
//        return value;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public synchronized int minusAndGet(int i) {
//        value -= i;
//        return value;
//    }

//  method 2： java.util.concurrent.locks.Lock
//    public Lock currentLock = new ReentrantLock();
//
//    public int addAndGet(int i) {
//        try {
//            currentLock.lock();
//            value += i;
//            return value;
//        } finally {
//            currentLock.unlock();
//        }
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public int minusAndGet(int i) {
//        try {
//            currentLock.lock();
//            value -= i;
//            return value;
//        } finally {
//            currentLock.unlock();
//        }
//
//    }
}

package com.github.hcsp.multithread;

import java.util.concurrent.locks.Lock;
//import java.util.concurrent.Callable;
//import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

//public class Counter {
//    //方法一：使用AtomicInteger
//    private AtomicInteger value = new AtomicInteger(0);
//
//    public int getValue() {
//        return value.get();
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public void addAndGet(int i) {
//        value.addAndGet(i);
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public void minusAndGet(int i) {
//        value.addAndGet(-i);
//    }
//
//}
//public class Counter implements Callable {
//    //方法二：synchronized方法
//    static int value = 0;
//    public int getValue() {
//        try {
//            return call();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    // 加上一个整数i，并返回加之后的结果
//    public synchronized void addAndGet(int i) {
//        value += i;
//    }
//
//    // 减去一个整数i，并返回减之后的结果
//    public synchronized void minusAndGet(int i) {
//        value -= i;
//    }
//
//    @Override
//    public Integer call() throws Exception {
//        return value;
//    }
//}
public class Counter {
    //方法三：使用java.util.concurrent.locks.Lock
    //Lock有比Synchronized更精确的线程予以和更好的性能。Synchronized会自动释放锁，但是Lock一定要求程序员手工释放，并且必须在finally从句中释放。

    Lock lock = new ReentrantLock();
    int value = 0;

    public int getValue() {
        return value;
    }

    // 加上一个整数i，并返回加之后的结果
    public void addAndGet(int i) {
        lock.lock();
        try {
            // Critical section here
            value += i;
        } finally {
            lock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public void minusAndGet(int i) {
        lock.lock();
        try {
            // Critical section here
            value -= i;
        } finally {
            lock.unlock();
        }
    }

}


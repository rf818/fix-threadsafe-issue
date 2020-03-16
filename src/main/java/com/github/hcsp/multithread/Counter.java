package com.github.hcsp.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger value = new AtomicInteger(0);

    public int getValue() {
        return value.intValue();
    }


    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        return value.addAndGet(i);

    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        return value.addAndGet(-i);
    }

}

/**
 *  ** method 1 **
 *
 * public synchronized int addAndGet(int i) {
 *  value += i;
 *  return value;
 * }
 *
 * public synchronized int minusAndGet(int i) {
 *   value -= i;
 *   return value;
 * }
 *
 *
 * ** method 2 **
 * public Lock lock = new ReentrantLock();
 *
 * // 加上一个整数i，并返回加之后的结果
 * public int addAndGet(int i) {
 *   try {
 *     lock.lock();
 *     value += i;
 *      return value;
 *   } finally {
 *     lock.unlock();
 *   }
 * }
 *
 * // 减去一个整数i，并返回减之后的结果
 * public int minusAndGet(int i) {
 *   try {
 *      lock.lock();
 *      value -= i;
 *      return value;
 *   } finally {
 *     lock.unlock();
 *   }
 * }
 */

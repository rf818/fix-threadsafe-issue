package com.github.hcsp.multithread;


import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger value = new AtomicInteger(0);

    public Integer getValue() {
        return value.get();
    }

    // 加上一个整数i，并返回加之后的结果
    public Integer addAndGet(int i) {
        value.addAndGet(i);
        System.out.println(value.get());
        return value.get();
    }

    // 减去一个整数i，并返回减之后的结果
    public Integer minusAndGet(int i) {
        value.addAndGet(-i);
        return value.get();
    }
}

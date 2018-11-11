package com.manjula.threadbasic.threadlocal;

public class TimeHolder {

    private static ThreadLocal<Long> threadLocal = ThreadLocal.withInitial(() -> System.currentTimeMillis());
    
    public Long get() {
        return threadLocal.get();
    }
    
    public void set() {
        threadLocal.set(System.currentTimeMillis());
    }
    
    public void print() {
        System.out.println(Thread.currentThread().getName() + " : " + get());
    }
    
}

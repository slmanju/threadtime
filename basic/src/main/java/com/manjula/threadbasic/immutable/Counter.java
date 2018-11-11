package com.manjula.threadbasic.immutable;

public final class Counter {
    
    private final int count;
    
    private Counter(int initialCount) {
        this.count = initialCount;
    }
    
    public static Counter newCounter(int initialCount) {
        return new Counter(initialCount);
    }
    
    public int getCount() {
        return this.count;
    }
    
    public Counter add(int value) {
        return new Counter(this.count + value);
    }

}

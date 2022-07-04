package com.rovo98.sgs.java8;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;

public class DirectIntArray {
    private final static long INT_SIZE_IN_BYTES = 4;

    private final long startIndex;

    private Unsafe unsafe;

    public DirectIntArray(long size) {
        initializeUnsafe();
        startIndex = unsafe.allocateMemory(size * INT_SIZE_IN_BYTES);
        unsafe.setMemory(startIndex, size * INT_SIZE_IN_BYTES, (byte) 0);

    }

    private void initializeUnsafe() {
        try {
            Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
            unsafeConstructor.setAccessible(true);
            unsafe = unsafeConstructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Can not instance unsafe object.");
        }
    }

    public void setValue(long index, int value) {
        unsafe.putInt(index(index), value);
    }

    public int getValue(long index) {
        return unsafe.getInt(index(index));
    }

    private long index(long offset) {
        return startIndex + offset * INT_SIZE_IN_BYTES;
    }

    public void destroy() {
        unsafe.freeMemory(startIndex);
    }
}

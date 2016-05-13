package com.nachepin;

import sun.misc.Unsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther huwhy
 * @date 2016/5/12.
 */
public class LockTest {

    public static void main(String[] args) {
    }

    private static Lock lock = new ReentrantLock();

    private static Unsafe unsafe = Unsafe.getUnsafe();


    private static void hello(int id, String msg) throws InterruptedException {

        if(lock.tryLock()) {
            Thread.sleep(1000);
            System.out.println("message:" + msg);
        }

    }
}

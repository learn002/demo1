package com.example.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by newtranx_011 on 2018/4/10.
 */
public class A98Lock implements Runnable {

    static int sum;
    private SpinLock spinLock;

    public A98Lock(SpinLock spinLock) {
        this.spinLock = spinLock;
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        for (int i = 0; i < 100; i++) {
            A98Lock a98Lock = new A98Lock(spinLock);
            Thread thread = new Thread(a98Lock);
            thread.start();

        }

        Thread.sleep(1000);
        System.out.println(sum);

    }

    @Override
    public void run() {
        this.spinLock.lock();
        sum++;
        this.spinLock.unLock();

    }
}

class SpinLock {
    AtomicReference<Thread> owner = new AtomicReference<>();
    private int count;
    public void lock() {
        Thread cur = Thread.currentThread();
        while (!owner.compareAndSet(null, cur)) {
            System.out.println(1);
        }
    }
    public void unLock() {
        Thread cur = Thread.currentThread();
        owner.compareAndSet(cur, null);
    }
}


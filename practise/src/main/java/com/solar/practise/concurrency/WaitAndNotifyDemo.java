package com.solar.practise.concurrency;

/**
 * @author huangzhibo
 * @date 2019-10-26
 */
public class WaitAndNotifyDemo {


    public static void testWaitMustHasLock() {

        boolean condition = false;
        final Object LOCK_OBJ = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (LOCK_OBJ) {
                while (!condition) {
                    try {
                        LOCK_OBJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK_OBJ){
                    if (!condition){
                        System.out.println("T1 working...");
                        //condition = true;
                        LOCK_OBJ.notify();
                    }
                }
            }
        });

    }


    public static void main(String[] args) {

    }

}

package com.solar.practise.concurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * @author huangzhibo
 * @date 2019-10-22
 */
public class LockSupport2 {

    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park!");
                LockSupport.park();
                System.out.println("child thread unpark!");
            }
        });

        thread.start();
        Thread.sleep(1000L);
        System.out.println("main thread begin unpark!");
        LockSupport.unpark(thread);
    }

}

package com.solar.practise.concurrency.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author huangzhibo
 * @date 2019-09-02
 */
public class ParentThread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " begin.");

        new Thread(() -> {
            for (int i = 0; i < 3; i++){
                System.out.println("current thread is: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e){

                }
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + " end.");

    }
}

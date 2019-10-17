package com.solar.practise.threadlocal.demo1;

import java.util.concurrent.CountDownLatch;

/**
 * @author huangzhibo
 * @date 2019-08-30
 */
public class Example1 {

    private String string;

    private String getString() {
        return string;
    }

    private void setString(String string) {
        this.string = string;
    }

//    public static void main(String[] args) {
//        int threads = 30;
//        Example1 demo = new Example1();
//        for (int i = 0; i < threads; i++) {
//            Thread thread = new Thread(() -> {
//                demo.setString(Thread.currentThread().getName());
//                System.out.println(demo.getString());
//            }, "thread - " + i);
//            thread.start();
//        }
//
//    }

    // 加锁
    public static void main(String[] args) {
        int threads = 30;
        Example1 demo = new Example1();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                demo.setString(Thread.currentThread().getName());
                System.out.println(demo.getString());
                countDownLatch.countDown();
            }, "thread - " + i);
            thread.start();
        }

    }


}

package com.solar.practise.concurrency;

import java.util.concurrent.locks.LockSupport;

/**
 * @author huangzhibo
 * @date 2019-10-22
 */
public class LockSupport1 {

    public static void main(String[] args) {
        System.out.println("begin park!");
        //LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park!");
    }

}

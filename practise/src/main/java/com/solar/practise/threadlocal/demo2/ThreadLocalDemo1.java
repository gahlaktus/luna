package com.solar.practise.threadlocal.demo2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzhibo
 * @date 2019-08-29
 */
public class ThreadLocalDemo1 {


    public static class R1 implements Runnable {

        private final static Map map = new HashMap();

        int id;

        public R1(int id){
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++){
                map.put(i, i + id * 100);
                try {
                    Thread.sleep(100);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "#.map.size()=" + map.size() + "#" + map);
        }
    }

    public static void main(String[] args) {


        Thread[] threads = new Thread[15];

        R1 r1 = new R1(1);

        for (int j = 0; j < threads.length; j++){
            threads[j] = new Thread(r1);
        }

        for (int k = 0; k < threads.length; k++){
            threads[k].start();
        }

    }

}

package com.solar.practise.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhibo
 * @date 2019-10-26
 */
public class ArrayListDemo {

    public static void fun0(){

        List<Integer> list0 = new ArrayList<>();

        long start0 = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            list0.add(i);
        }

        System.out.println(System.currentTimeMillis() - start0);

        long start1 = System.currentTimeMillis();

        List<Integer> list1 = new ArrayList<>();

        for (int i = 10000000; i < 20000000; i++) {
            list1.add(i);
        }

        System.out.println(System.currentTimeMillis() - start1);


    }

    public static void main(String[] args) {
        fun0();
    }

}

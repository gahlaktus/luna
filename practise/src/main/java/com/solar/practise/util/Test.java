package com.solar.practise.util;

/**
 * @author huangzhibo
 * @date 2019-08-14
 */
public class Test {

    public static void main(String[] args) {
        MapBuilder<String> builder = new MapBuilder.Builder().map("a", "b").build();
        System.out.println(builder.get("a"));
    }

}

package com.solar.practise.tdd;

/**
 * @author huangzhibo
 * @date 2019-10-23
 */
public class FizzBuzz {

    public static void printFizzBuzz(int num) {

        for (int i = 1; i <= num; i++) {
            System.out.println(convert(i));
        }

    }

    public static String convert(int originNum) {
        String target = originNum + "";
        if (originNum % 3 == 0) {
            if (originNum % 5 == 0) {
                target = "FizzBuzz";

            } else {
                target = "Fizz";
            }
        } else if (originNum % 5 == 0) {
            target = "Buzz";
        }
        return target;
    }

}

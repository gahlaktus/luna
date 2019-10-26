package com.solar.practise.tdd;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author huangzhibo
 * @date 2019-10-23
 */
public class FizzBuzzTest {

    @Test
    public void printFizzBuzz() {

        String test1 = FizzBuzz.convert(1);
        Assert.assertEquals("1", test1);

        String test3 = FizzBuzz.convert(3);
        Assert.assertEquals("Fizz", test3);

        String test5 = FizzBuzz.convert(5);
        Assert.assertEquals("Buzz", test5);

        String test15 = FizzBuzz.convert(15);
        Assert.assertEquals("FizzBuzz", test15);

        String test96 = FizzBuzz.convert(96);
        Assert.assertEquals("Fizz", test96);

        String test40 = FizzBuzz.convert(40);
        Assert.assertEquals("Buzz", test40);

    }
}
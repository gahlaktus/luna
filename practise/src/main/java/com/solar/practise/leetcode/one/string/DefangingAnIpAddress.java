package com.solar.practise.leetcode.one.string;

/**
 * @author huangzhibo
 * @date 2019-09-17
 */
public class DefangingAnIpAddress {

    public static String defangIPaddr(String address) {

        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String s = "4.4.44.4";
        System.out.println(defangIPaddr(s));
    }

}

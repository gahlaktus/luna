package com.solar.practise.leetcode;

/**
 * @author huangzhibo
 * @date 2019-09-23
 */
public class RemoveKZeros {


    public static String removeKZeros(String s, int k){

        if (s == null || k < 1){
            return null;
        }

        int count = 0, start = -1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '0'){
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k){
                    while (count-- != 0){
                        chars[start++] = '\0';
                    }
                } else {
                    count = 0;
                    start = -1;
                }
            }
        }

        if (count == k){
            while (count-- != 0){
                chars[start++] = 0;
            }
        }

        return String.valueOf(chars);

    }

    public static void main(String[] args) {

        String s1 = "A00B";

        System.out.println(removeKZeros(s1, 2));

        String s2 = "A0000B000";

        System.out.println(removeKZeros(s2, 3));

    }

}

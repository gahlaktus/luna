package com.solar.practise.leetcode.one.string;

import java.util.Arrays;

/**
 * 821
 * 字符、字节
 *
 * @author huangzhibo
 * @date 2019-09-16
 */
public class ShortestDistanceToACharacter {

    /**
     * 遍历三次，两次 S，一次len数组， O(n)，3N
     * 空间2N(len) O(n)
     * @param s
     * @param c
     * @return
     */
    public static int[] shortestToChar0(String s, char c) {

        int len = s.length();
        int[] left = new int[len], right = new int[len];
        left[0] = s.charAt(0) == c ? 0 : 10000;
        for (int i = 1; i < len; i++){
            left[i] = s.charAt(i) == c ? 0 : left[i-1] + 1;
        }
        right[len -1] = s.charAt(len-1) == c ? 0 : 10000;
        for (int j = len-2; j >= 0; j--){
            right[j] = s.charAt(j) == c ? 0 : right[j+1] + 1;
        }
        for (int k = 0; k < len; k++){
            left[k] = Math.min(left[k], right[k]);
        }
        return left;

    }


    public static int[] shortestToChar1(String s, char c){

        int len = s.length();
        int[] distance = new int[len];
        distance[0] = s.charAt(0) == c ? 0 : 10000;
        for (int i = 1; i < len; i++){
            distance[i] = s.charAt(i) == c ? 0 : distance[i-1] + 1;
        }
        int pre = distance[len-1];
        distance[len-1] = s.charAt(len-1) == c ? 0 : Math.min(pre, 10000);
        for (int j = len-2; j >= 0; j--){
            int preIndex = distance[j];
            distance[j] = s.charAt(j) == c ? 0 : Math.min(preIndex, (distance[j+1]+1));
        }
        return distance;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        System.out.println(Arrays.toString(shortestToChar0(s, c)));

        System.out.println(Arrays.toString(shortestToChar1(s, c)));
    }
}

package com.solar.practise.leetcode.one;

import java.util.PriorityQueue;

/**
 * @author huangzhibo
 * @date 2019-10-23
 */
public class KthLargestElementInAnArray {

    private static int findKthLargest(int[] nums, int k){

        PriorityQueue<Integer> topKLargestQueue = new PriorityQueue(k);
        for (int num : nums){
            if (topKLargestQueue.size() < k || num > topKLargestQueue.peek()){
                topKLargestQueue.offer(num);
            }
            if (topKLargestQueue.size() > k){
                topKLargestQueue.poll();
            }
        }
        return topKLargestQueue.peek();
    }

    public static void main(String[] args) {
        int[] testArr = new int[]{1, 2, 11, 23, 5, 34, 90, 56, 76};
        System.out.println(findKthLargest(testArr, 2));
    }

}

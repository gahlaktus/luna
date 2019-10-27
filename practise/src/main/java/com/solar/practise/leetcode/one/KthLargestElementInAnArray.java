package com.solar.practise.leetcode.one;

import java.util.PriorityQueue;

/**
 * @author huangzhibo
 * @date 2019-10-23
 */
public class KthLargestElementInAnArray {

    private static int findKthLargest0(int[] nums, int k) {

        PriorityQueue<Integer> topKLargestQueue = new PriorityQueue(k);
        for (int num : nums) {
            if (topKLargestQueue.size() < k || num > topKLargestQueue.peek()) {
                topKLargestQueue.offer(num);
            }
            if (topKLargestQueue.size() > k) {
                topKLargestQueue.poll();
            }
        }
        return topKLargestQueue.peek();
    }

    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i != k; i++) {
            buildHeap(kHeap, arr[i], i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    /**
     * K-大顶堆
     * 弱有序
     *
     * @param heapArr 堆-数组
     * @param value   入堆的值
     * @param index   堆-数组下标
     */
    private static void buildHeap(int[] heapArr, int value, int index) {
        heapArr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (heapArr[parent] < heapArr[index]) {
                swap(heapArr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private static void heapify(int[] heapArr, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (heapArr[left] > heapArr[index]) {
                largest = left;
            }
            if (right < heapSize && heapArr[right] > heapArr[largest]) {
                largest = right;
            }
            if (largest != index) {
                swap(heapArr, largest, index);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static int findKthLargest1(int[] nums, int k) {
        if(k < 1 || k > nums.length){
            throw new IllegalArgumentException("Illegal K");
        }
        int[] kHeap = new int[k];
        for(int i = 0; i != k; i++){
            kHeap[i] = nums[i];
            int cur = i;
            while(cur != 0){
                int parent = (cur - 1 ) / 2;
                if(kHeap[parent] > kHeap[cur]){
                    int tmp = kHeap[cur];
                    kHeap[cur] = kHeap[parent];
                    kHeap[parent] = tmp;
                    cur = parent;
                } else {
                    break;
                }
            }
        }
        for(int j = k; j < nums.length; j++){
            if(nums[j] > kHeap[0]){
                kHeap[0] = nums[j];
                int cur = 0;
                int left = 1;
                int right = 2;
                int smallest = cur;
                while(left < k){
                    if(kHeap[left] < kHeap[cur]){
                        smallest = left;
                    }
                    if(right < k && kHeap[right] < kHeap[smallest]){
                        smallest = right;
                    }
                    if(smallest != cur){
                        int tmp = kHeap[cur];
                        kHeap[cur] = kHeap[smallest];
                        kHeap[smallest] = tmp;
                    } else {
                        break;
                    }
                    left = 2 * smallest + 1;
                    right = 2 * smallest + 2;
                    cur = smallest;
                }
            }
        }
        return kHeap[0];
    }

    public static void main(String[] args) {
        int[] testArr = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest0(testArr, 4));
        System.out.println(findKthLargest1(testArr, 4));
    }

}

package com.solar.practise.algorithm;

import java.util.Arrays;

/**
 * @author huangzhibo
 * @date 2019-10-08
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int start, int end){
        if (start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end){
        int[] tempArr = new int[end-start+1];

        int p1 = start, p2 = mid + 1, p = 0;
        while (p1 <= mid && p2 <= end){
            if (arr[p1] <= arr[p2]){
                tempArr[p++] = arr[p1++];
            } else {
                tempArr[p++] = arr[p2++];
            }
        }
        while (p1 <= mid){
            tempArr[p++] = arr[p1++];
        }
        while (p2 <= end){
            tempArr[p++] = arr[p2++];
        }
        for (int i = 0; i < tempArr.length; i++){
            arr[i+start] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}

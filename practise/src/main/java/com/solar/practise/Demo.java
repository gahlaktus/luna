package com.solar.practise;

/**
 * @author huangzhibo
 * @date 2019-10-10
 */
public class Demo {

    public static int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //用来保存当前的最大值
        int greatestSum = array[0];
        //表示当前的和
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (currentSum <= 0) {
                //当前和小于等于0，保存当前的最大值
                currentSum = array[i];
            } else {
                //当前和大于0，接着累加后面的元素
                currentSum = currentSum + array[i];
            }
            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int[] testArr = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestSumOfSubArray(testArr));
    }

}

package com.solar.practise.leetcode.one;

/**
 * @author huangzhibo
 * @date 2019-10-23
 */
public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[]{-1, -1};

        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == t) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }

    /**
     * 相比上面的解法，局部变量少了，代码量也少了，更清晰。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}

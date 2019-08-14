package com.solar.practise.leetcode.tree;

/**
 * item 938
 *
 * 二分搜索树、二叉搜索树
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 *
 * Note:
 *
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 *
 * @author huangzhibo
 * @date 2019-08-12
 */
public class RangeSumOfBst {

    public int rangeSumBst(TreeNode root, int L, int R) {

        if (root == null){
            return 0;
        }
        if (L > R){
            return 0;
        }

        int sum = 0;

        if (root.val >= R){
            if (root.val == R){
                sum += root.val;
            }
            sum += rangeSumBst(root.left, L, R);
        } else if (root.val <= L){
            if(root.val == L){
                sum += root.val;
            }
            sum += rangeSumBst(root.right, L, R);
        } else if (root.val > L && root.val < R){
            sum += root.val;
            sum += rangeSumBst(root.left, L, R);
            sum += rangeSumBst(root.right, L, R);
        }
        return sum;

    }

}

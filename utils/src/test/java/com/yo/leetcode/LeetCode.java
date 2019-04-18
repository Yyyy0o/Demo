package com.yo.leetcode;

import org.junit.Test;

public class LeetCode {

    @Test
    public void fun1() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));

    }

    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            rev = rev * 10 + pop;
        }

        return rev;
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

}

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

    @Test
    public void fun2() {
        System.out.println(isPalindrome(10));
    }

    public boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }

        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rev = 0;

        while (rev < x) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
        }

        return rev == x || x == rev / 10;
    }

    @Test
    public void fun3(){
        System.out.println(Math.ceil(55.5-55.55));
        System.out.println(Math.ceil("55.55".compareTo("55.55")));
        System.out.println(Math.ceil("55.55".compareTo("55.5")));
        System.out.println(Math.ceil("55.5".compareTo("55.55")));
    }
}

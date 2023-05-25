package org.example;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * O(n)
 */
public class ProductOfArrayExceptSelf6 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums){
        int[] res = new int[nums.length];
        int prefix = 1, postfix = 1;

        for(int i=0; i<nums.length; i++){
            res[i] = prefix;
            prefix *= nums[i];
        }

        for(int j=nums.length-1; j>=0; j--){
            res[j] *= postfix;
            postfix *= nums[j];
        }
        return res;
    }
}

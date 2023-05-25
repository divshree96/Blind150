package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 */

public class ContainsDuplicate1 {

    public static void main(String[] args){
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i< nums.length; i++){
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }

}

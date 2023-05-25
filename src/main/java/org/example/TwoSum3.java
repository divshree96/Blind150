package org.example;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target,return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum3 {
    public static void main(String[] args){
        int[] res = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(hm.containsKey(target - nums[i]))
                return new int[]{hm.get(target-nums[i]), i};
            hm.put(nums[i], i);
        }
        return new int[]{};
    }
}

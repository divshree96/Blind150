package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 */
public class ThreeSum9 {
    public static void main(String[] args){
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}).toString());
    }

    /**
     * We will pick a pointer a and then for remaining rest we will do a two sum-II using
     * left and right pointers
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //O(nlogn)

        for(int i=0; i< nums.length-2; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //to check if the previous i is same as past i so that there is not duplicate set
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] == 0) {
                        List<Integer> ll = new ArrayList<>();
                        ll.add(nums[i]);
                        ll.add(nums[left]);
                        ll.add(nums[right]);
                        res.add(ll);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[i] > 0)
                        right--;
                    else
                        left++;
                }
            }
        }

        return res;

    }
}

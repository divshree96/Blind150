package org.example;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * https://leetcode.com/problems/container-with-most-water/
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Input: height = [1,1]
 * Output: 1
 */

public class ContainerWithMostWater10 {
    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;
        int res = 0;

        while(left<=right){
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);

            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }
}

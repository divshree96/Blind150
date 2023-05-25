package org.example;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class TrappingRainWater11 {
    public static void main(String[] args){
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
        System.out.println(trapSolution2(new int[]{4,2,0,3,2,5}));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n) + O(n) + O(n)
     * @param height
     * @return
     */
    public static int trap(int[] height){
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLeftRight = new int[height.length];

        //FORMULA: minLeftRight - height[i] > 0

        int left = 0;
        for(int i = 0; i < height.length; i++){
            maxLeft[i] = left;
            left = Math.max(left, height[i]);
        }

        int right = 0;
        for(int j= height.length-1; j >= 0; j--) {
            maxRight[j] = right;
            right = Math.max(right, height[j]);
        }

        for(int i = 0; i < height.length; i++){
            minLeftRight[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        int output = 0;

        for(int i=0; i < height.length; i++){
            if(minLeftRight[i] - height[i] > 0)
                output += minLeftRight[i] - height[i];
        }

        return output;
    }

    /**
     * Time Complexity: O(1)
     * @param height
     * @return
     */
    public static int trapSolution2(int[] height){
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;

        while(left < right){
            //increment left pointer
            if(leftMax <= rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                if(leftMax - height[left] > 0)
                    res += leftMax - height[left];
            }
            //decrement right pointer
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                if(rightMax - height[right] > 0)
                    res += rightMax - height[right];
            }
        }
        return res;
    }
}

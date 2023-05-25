package org.example;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */

public class TopKFrequentElements5 {
    public static void main(String[] args){
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    public static int[] topKFrequent(int[] nums, int k){

        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

//        for(int n: nums){
//            if(hm.containsKey(n))
//                hm.put(n, hm.get(n)+1);
//            hm.put(n,1);
//        }

        for(int i=0; i< nums.length; i++){
            if(!hm.containsKey(nums[i]))
                hm.put(nums[i], 1);
            else {
                hm.put(nums[i], hm.get(nums[i])+1);
            }
        }

        for(int i=0; i<= nums.length; i++){
            res.add(new ArrayList<>());
        }

        for (Map.Entry<Integer,Integer> mapElement : hm.entrySet()) {
            res.get(mapElement.getValue()).add(mapElement.getKey());
        }

        while(k!=0){
        }

        return new int[]{};
    }
}

//class Solution1 {
//
//    /**
//     * Time Complexity: O(nlog(k))
//     * Space Complexity: O(n)
//     */
//    public int[] topKFrequent(int[] nums, int k) {
//        int[] arr = new int[k];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
//                (a, b) ->
//                        a.getValue() - b.getValue()
//        );
//        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
//            pq.add(it);
//            if (pq.size() > k) pq.poll();
//        }
//        int i = k;
//        while (!pq.isEmpty()) {
//            arr[--i] = pq.poll().getKey();
//        }
//        return arr;
//    }
//}
//
//class Solution2 {
//
//    /**
//     * Time Complexity: O(n)
//     * Space Complexity: O(n)
//     */
//    public int[] topKFrequent(int[] numbers, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int number : numbers) map.put(
//                number,
//                map.getOrDefault(number, 0) + 1
//        );
//
//        int size = map.size();
//        int[] keys = new int[size];
//        int i = 0;
//        for (int key : map.keySet()) keys[i++] = key;
//
//        select(keys, map, 0, size - 1, size - k);
//        return Arrays.copyOfRange(keys, size - k, size);
//    }
//
//    // Modified implementation of Hoare's selection algorithm:
//
//    private void select(
//            int[] keys,
//            Map<Integer, Integer> map,
//            int left,
//            int right,
//            int kSmallest
//    ) {
//        while (left != right) {
//            int pivot = partition(keys, map, left, right, (left + right) / 2);
//
//            if (kSmallest == pivot) return;
//
//            if (kSmallest < pivot) right = pivot - 1; else left = pivot + 1;
//        }
//    }
//
//    private int partition(
//            int[] keys,
//            Map<Integer, Integer> map,
//            int left,
//            int right,
//            int pivot
//    ) {
//        int pivotValue = map.get(keys[pivot]);
//        swap(keys, pivot, right);
//        int index = left;
//
//        for (int i = left; i <= right; i++) if (map.get(keys[i]) < pivotValue) {
//            swap(keys, i, index);
//            index++;
//        }
//        swap(keys, right, index);
//        return index;
//    }
//
//    private void swap(int[] array, int i1, int i2) {
//        int temp = array[i1];
//        array[i1] = array[i2];
//        array[i2] = temp;
//    }
//}
//class Solution3 {
//    /**
//     * Time Complexity: O(n)
//     * Space Complexity: O(n)
//     */
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> count = new HashMap<>();
//        List<Integer> bucket[] = new ArrayList[nums.length + 1];
//
//        for (int num : nums)
//            count.merge(num, 1, Integer::sum);
//
//        for (int key : count.keySet()){
//            int freq = count.get(key);
//            if (bucket[freq] == null)
//                bucket[freq] = new ArrayList<>();
//            bucket[freq].add(key);
//        }
//
//        int index = 0;
//        int[] res = new int[k];
//        for (int i = nums.length; i >= 0; i--)
//            if (bucket[i] != null)
//                for (int val : bucket[i]){
//                    res[index++] = val;
//                    if(index == k)
//                        return res;
//                }
//        return res;
//    }
//

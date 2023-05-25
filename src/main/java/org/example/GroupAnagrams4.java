package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams4 {
    public static void main(String[] args){
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> res = new ArrayList<>();

        if(strs.length == 0) return res;

        HashMap<String, List<String>> hm= new HashMap<>();
        for(int i=0; i< strs.length; i++){
            String s = strs[i];
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String s_temp = new String(ch);

            hm.computeIfAbsent(s_temp, t -> new ArrayList<>());
            hm.get(s_temp).add(s);
        }
        res.addAll(hm.values());
        return res;
    }
}

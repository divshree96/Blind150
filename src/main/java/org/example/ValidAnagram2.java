package org.example;

import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagram2 {
    public static void main(String[] args){
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;

        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();

        Arrays.sort(arr_s);
        Arrays.sort(arr_t);

        String s1 = new String(arr_s);
        String t1 = new String(arr_t);

        if(s1.equals(t1))
            return true;
        else
            return false;
    }
}

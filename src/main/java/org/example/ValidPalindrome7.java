package org.example;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class ValidPalindrome7 {
    public static void main(String[] args){
        System.out.println(isPalindrome("race a car"));

    }
    public static boolean isPalindrome(String str){
        String s = new String();

        for(int i=0; i<str.length(); i++){
            int ch = (int) str.charAt(i);
            if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)){
                s = s + Character.toLowerCase(str.charAt(i));
            }

        }

        s.toLowerCase();
        System.out.println(s);
        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }

    /**
     *
     * To optimize it further from O(n) + O (n/2) what we can do is check if the character is alphanumeric if it is then
     * move front or back respectively else check if the characters at left and right are equal basically combine the
     * two loops so that time complexity is O(n)
     *
     *
     * public static boolean isPalindrome(String s) {
     *         int left = 0;
     *         int right = s.length()-1;
     *
     *         while(left <= right) {
     *             if(alphaNum((int)s.charAt(left)) == false)
     *                 left++;
     *             else if(alphaNum((int)s.charAt(right)) == false)
     *                 right--;
     *             else if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
     *                 return false;
     *             else {
     *                 left++;
     *                 right--;
     *             }
     *         }
     *         return true;
     *     }
     *
     *     public boolean alphaNum(int ch) {
     *         if((ch >=97 && ch<=122) || (ch >= 65 && ch<=90) || (ch>= 48 && ch<= 57))
     *             return true;
     *         return false;
     *     }
     */
}

package org.example;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Input: s = "()"
 * Output: true
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Input: s = "(]"
 * Output: false
 */
public class ValidParentheses12 {

    public static void main(String[] args){
        System.out.println(isValid("(}"));
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.add(s.charAt(i));
            else{
                if(stack.isEmpty())
                    return false;
                else {
                    if((stack.peek() == '(' && s.charAt(i) == ')') ||
                            (stack.peek() == '{' && s.charAt(i) == '}') ||
                            (stack.peek() == '[' && s.charAt(i) == ']'))
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}

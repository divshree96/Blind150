package org.example;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses15 {
    //only add open parenthesis if open < n
    //only add close parenthesis if close < open
    //valid if open = close = n

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursive(res, 0, 0, "", n);
        return res;
    }

    public void recursive(List<String> res, int open, int close, String s, int n) {
        if(s.length() == n*2){
            res.add(s);
            return;
        }

        if(open < n) {
            recursive(res, open+1, close, s+ "(", n);
        }

        if(close < open) {
            recursive(res, open, close+1, s+")", n);
        }

    }
}

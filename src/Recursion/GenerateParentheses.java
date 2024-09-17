package Recursion;

import java.util.ArrayList;
import java.util.List;
public class GenerateParentheses {
    public static void main(String[] args) {
        int open = 1;
        int close = 0;
        String p = "(";
        int n = 8;
        int cnt = 2*n -1;
        System.out.println(generateParentheses(p,cnt, open,close));
    }

    private static List<String> generateParentheses(String p, int cnt, int open, int close) {
        // if closed parentheses becomes more than open then they won't contribute to the answer afterwords so stop their recursion calls
        if(close > open){
            return new ArrayList<>();
        }

        if(cnt == 0){
            if((open == close)){
                List<String> list = new ArrayList<>();
                list.add(p);
                return list;
            }
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        ans.addAll(generateParentheses(p+")",cnt-1,open,close+1));
        ans.addAll(generateParentheses(p+"(",cnt-1,open+1,close));

        return ans;
    }
}

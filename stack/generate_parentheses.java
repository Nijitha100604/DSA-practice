package stack;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]
*/

import java.util.*;

public class generate_parentheses {

    public static List<String> generateParantheses(int n){
        List<String> ans = new ArrayList<>();
        generate(ans, "", 0, 0, n);
        return ans;
    }

    public static void generate( List<String> ans, String s, int open, int close, int n ){
        if(s.length() == n*2){
            ans.add(s);
            return;
        }

        if(open < n){
            generate(ans, s+"(", open+1, close, n);
        }

        if(close < open){
            generate(ans, s+")", open, close+1, n);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generateParantheses(n));
        sc.close();
    }
}

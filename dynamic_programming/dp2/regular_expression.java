package dynamic_programming.dp2;

/* 
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
Return a boolean indicating whether the matching covers the entire input string (not partial).

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
*/

import java.util.*;

public class regular_expression {

    public static boolean isMatch(String s, String p){
        int r = s.length();
        int c = p.length();

        boolean[][] dp = new boolean[r+1][c+1];
        dp[0][0] = true;

        for(int j=2; j<=c; j++){
            if(p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-2];
        }

        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                }
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.println(isMatch(s,p));
        sc.close();
    }
}

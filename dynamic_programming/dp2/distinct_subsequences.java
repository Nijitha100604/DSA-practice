package dynamic_programming.dp2;

/* 
Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag

*/

import java.util.*;

public class distinct_subsequences {

    public static int numDistinct(String s, String t){
        int r = s.length();
        int c = t.length();
        int[][] dp = new int[r+1][c+1];

        for(int i=0; i<=r; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(numDistinct(s,t));
        sc.close();
    }
}

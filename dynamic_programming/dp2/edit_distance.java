package dynamic_programming.dp2;

/* 
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

import java.util.*;

public class edit_distance {

    public static int minDistance(String word1, String word2){
        int r = word1.length();
        int c = word2.length();
        int[][] dp = new int[r+1][c+1];

        for(int i=1; i<=c; i++)
            dp[0][i] = i;

        for(int i=1; i<=c; i++)
            dp[i][0] = i;

        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(word1.charAt(j-1) == word2.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int top = dp[i-1][j];
                    int left = dp[i][j-1];
                    int diagonal = dp[i-1][j-1];
                    dp[i][j] = Math.min(top, Math.min(left, diagonal))+1;
                }
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        System.out.println(minDistance(word1, word2));
        sc.close();
    }
}

package dynamic_programming.dp1;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false 
*/

import java.util.*;

public class word_break {

    public static boolean wordBreak(String s, List<String> wordDict){
        Set<String> hashset = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        int maxLen = 0;
        for(String word: wordDict){
            maxLen = Math.max(maxLen, word.length());
        }

        for(int i=1; i<=s.length()+1; i++){
            for(int j=i-1; j>= Math.max(0, i-maxLen); j--){
                if(dp[j] && hashset.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<String> wordDict = new ArrayList<>(num);
        for(int i=0; i<num; i++){
            wordDict.add(sc.next());
        }
        String s = sc.next();
        System.out.println(wordBreak(s, wordDict));
        sc.close();
    }
}

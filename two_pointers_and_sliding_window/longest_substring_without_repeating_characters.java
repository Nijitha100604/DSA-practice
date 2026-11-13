package two_pointers_and_sliding_window;

/* 
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.*;

public class longest_substring_without_repeating_characters {

    public static int lengthOfLongestSubstring(String s){
        int start = 0;
        int end = 0;
        int maxLen = Math.min(s.length(), 1);
        Set<Character> seen = new HashSet<>();
        while(end < s.length()){
            char ch = s.charAt(end);
            while(seen.contains(ch)){
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(ch);
            maxLen = Math.max(maxLen, (end - start + 1));
            end++;
        }
        return maxLen; 
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
        sc.close();
    }
}

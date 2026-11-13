package two_pointers_and_sliding_window;

/* 
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 
*/

import java.util.*;

public class minimum_window_substring {

    public static String minWindow(String s, String t){
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        
        for(char ch: t.toCharArray())
            tMap[ch]++;

        while(end < s.length()){
            sMap[s.charAt(end)]++;

            while(contains(sMap, tMap)){
                if(end - start + 1 < minLen){
                    minLen = end - start + 1;
                    minStart = start;
                }
                sMap[s.charAt(start)]--;
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static boolean contains(int[] sMap, int[] tMap){
        for(int i=0; i<256; i++){
            if(tMap[i] > sMap[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s,t));
        sc.close();
    }
}

package dynamic_programming.dp1;

/* 
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"
*/

import java.util.*;

public class longest_palindromic_substring {

    public static String longestPalindrom(String s){
        int start = 0;
        int end = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            int len1 = palindrome(s, i, i);
            int len2 = palindrome(s, i, i+1);
            int len = Math.max(len1, len2);

            if(len > (end - start)){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }

    public static int palindrome(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestPalindrom(s));
        sc.close();
    }
}

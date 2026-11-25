package dynamic_programming.dp1;

/* 
Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

import java.util.*;

public class palindromic_substrings {

    public static int countSubstrings(String s){
        int total = 0;
        
        for(int i=0; i<s.length(); i++){
            int odd = getCount(s, i, i);
            int even = getCount(s, i, i+1);
            total = total + (odd + even);
        }

        return total;
    }

    public static int getCount(String s, int l, int r){
        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(countSubstrings(s));
        sc.close();
    }
}

package arrays_and_hashing;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false 
*/

import java.util.*;

public class valid_anagram {

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;

        // Approach 1: Using HashMap
        /* 
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sCount.equals(tCount);
        */

        // Approach 2: Using Array
        int[] countArr = new int[26];
        for(int count = 0; count < s.length(); count++){
            countArr[s.charAt(count) - 'a']++;
            countArr[t.charAt(count) - 'a']--;
        }

        for(int count: countArr){
            if(count != 0)
                return false;
        }
        return true;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isAnagram(s, t));
        sc.close();
    }
}

package two_pointers_and_sliding_window;

/* 
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
*/

import java.util.*;

public class permutation_in_string {

    public static boolean checkInclusion(String s1, String s2){
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            if(!need.containsKey(c)) 
                need.put(c, 0);
            need.put(c, need.get(c)+1);
        }

        int start = 0;
        int end = 0;
        while(end < s2.length()){
            char c = s2.charAt(end);

            if(!need.containsKey(c)){
                have.clear();
                end++;
                start = end;
                continue;
            }

            if(!have.containsKey(c))
                have.put(c, 0);
            have.put(c, have.get(c)+1);

            while(have.get(c) > need.get(c)){
                char stch = s2.charAt(start);
                have.put(stch, have.get(stch)-1);
                start++;
            }

            int windowSize = end - start + 1;
            if(windowSize == s1.length())
                return true;
            
            end++;
        }

        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(checkInclusion(s1, s2));
        sc.close();
    }
}

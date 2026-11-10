package arrays_and_hashing;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]] 
*/

import java.util.*;

public class group_anagrams {

    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs.length == 0 || strs == null)
            return new ArrayList<>();

        Map<String, List<String>> mp = new HashMap<>();
        for(String str: strs){

            // Create a count array to store the frequency of each character in the string
            /*
            int[] count = new int[26];
            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            */

            // Sort the string to create a key for the anagram group
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            if(!mp.containsKey(key)){
                mp.put(key, new ArrayList<>());
            }
            mp.get(key).add(str);
        }
        return new ArrayList<>(mp.values());
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] arr = new String[num];
        for(int count = 0; count < num; count++){
            String value = sc.nextLine();
            arr[count] = value;
        }
        System.out.println(groupAnagrams(arr));
        sc.close();
    }
}

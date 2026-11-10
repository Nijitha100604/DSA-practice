package arrays_and_hashing;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4

Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Explanation: The longest consecutive elements sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8]. Therefore its length is 9.
*/

import java.util.*;

public class longest_consecutive_sequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums)
            set.add(num);

        int longest = 1;
        for(int num: set){
            if(!set.contains(num-1)){
                int count = 1;
                int current = num;
                while(set.contains(current + 1)){
                    count++;
                    current++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(longestConsecutive(arr));
        sc.close();
    }
}

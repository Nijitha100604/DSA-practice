package arrays_and_hashing;

/* 
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]
Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

*/
import java.util.*;

public class contains_duplicate {
    public static boolean containsDuplicate(int[] nums) {
        
        Set<Integer> seen = new HashSet<>();
        for(int num:nums){
            if(seen.contains(num))
                return true;
            seen.add(num);
        }
        return false;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            int value = sc.nextInt();
            arr[i] = value;
        }
        System.out.println(containsDuplicate(arr));
        sc.close();
    }
}

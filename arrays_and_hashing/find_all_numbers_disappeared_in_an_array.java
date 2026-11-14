package arrays_and_hashing;

/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2] 
*/

import java.util.*;

public class find_all_numbers_disappeared_in_an_array {

    public static List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);

        for(int i=1; i<=nums.length; i++){
            if(!set.contains(i))
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(findDisappearedNumbers(arr));
        sc.close();
    }
}

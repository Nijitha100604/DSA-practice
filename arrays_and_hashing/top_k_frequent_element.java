package arrays_and_hashing;

/* 
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]
*/

import java.util.*;

public class top_k_frequent_element {

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int count = 0; count < nums.length; count++){
            if(!freqMap.containsKey(nums[count])) 
                freqMap.put(nums[count], 0);
            freqMap.put(nums[count], freqMap.get(nums[count])+1);
        }

        Map<Integer, List<Integer>> revMap = new HashMap<>();
        for(int num: freqMap.keySet()){
            int count = freqMap.get(num);
            if(!revMap.containsKey(count))
                revMap.put(count, new ArrayList<>());
            revMap.get(count).add(num);
        }

        int index = 0;
        for(int max = nums.length; max >= 1; max--){
            if(revMap.containsKey(max)){
                for(int num: revMap.get(max)){
                    if(index < k)
                        result[index++] = num;
                    else
                        break;
                }
            }
            if(index > k)
                break;
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int count = 0; count < num; count++){
            int value = sc.nextInt();
            arr[count] = value;
        }
        int k = sc.nextInt();
        System.out.println(topKFrequent(arr, k));
        sc.close();
    }
}

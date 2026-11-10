package arrays_and_hashing;

/*
You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Explanation:

The sum of nums[0] and nums[1] is 2 + 7 = 9, which equals the target. Therefore, the indices [0, 1] are returned.

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Explanation:

The sum of nums[1] and nums[2] is 2 + 4 = 6, which equals the target. Therefore, the indices [1, 2] are returned.

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Explanation:

The sum of nums[0] and nums[1] is 3 + 3 = 6, which equals the target. Therefore, the indices [0, 1] are returned.
*/
import java.util.*;

public class two_sum {

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int count = 0; count < nums.length; count++){
            int value = target - nums[count];
            if(mp.containsKey(value)){
                ans[0] = mp.get(value);
                ans[1] = count;
                break;
            }
            mp.put(nums[count], count);
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int count = 0; count < num; count++){
            int value = sc.nextInt();
            arr[count] = value;
        }
        int target = sc.nextInt();
        System.out.println(twoSum(arr, target));
        sc.close();
    }
}

package two_pointers_and_sliding_window;

/* 
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:

Input: nums = [1], k = 1
Output: [1]
*/

import java.util.*;

public class sliding_window_maximum {

    public static int[] maxSlidingWindow(int[] nums, int k){
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result[0] = nums[deque.peekFirst()];

        for(int i=k; i<nums.length; i++){
            if(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);
            result[i-k+1] = nums[deque.peekFirst()];
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
        int k = sc.nextInt();
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
        sc.close();
    }
}

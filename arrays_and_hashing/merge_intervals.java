package arrays_and_hashing;

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping. 
*/

import java.util.*;

public class merge_intervals {

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int index = 0;

        List<int[]> resList = new ArrayList<>();
        while(index < intervals.length){
            int newStart = intervals[index][0];
            int currEnd = intervals[index][1];
            while(index < intervals.length - 1 && currEnd >= intervals[index+1][0]){
                currEnd = Math.max(currEnd, intervals[index+1][1]);
                index++;
            }
            resList.add(new int[]{newStart, currEnd});
            index++;
        }

        index = 0;
        int[][] result = new int[resList.size()][2];
        for(int[] arr: resList){
            result[index++] = arr;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int[][] arr = new int[rows][2];
        for(int i=0; i<rows; i++){
            for(int j=0; j<2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] result = merge(arr);
        System.out.println(Arrays.deepToString(result));
        sc.close();
    }
}

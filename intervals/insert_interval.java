package intervals;

/*

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Two intervals are considered overlapping if they share at least one point.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.


Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

*/
import java.util.*;

public interface insert_interval {

    public static int[][] insert(int[][] intervals, int[] newInterval){

        List<int[]> result = new ArrayList<>();
        int i=0;
        int n = intervals.length;

        while(i<n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        result.add(newInterval);

        while(i<n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);

    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] intervals = new int[num][2];
        for(int i=0; i<num; i++){
            for(int j=0; j<2; j++){
                intervals[i][j] = sc.nextInt();
            }
        }
        int[] newInterval = new int[2];
        for(int i=0; i<2; i++)
            newInterval[i] = sc.nextInt();
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
        sc.close();
    }

}

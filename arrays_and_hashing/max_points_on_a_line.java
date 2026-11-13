package arrays_and_hashing;

/* 
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 
Example 1:

Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Example 2:

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
*/

import java.util.*;

public class max_points_on_a_line {

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2)
            return n;
        
        int result = 0;
        for(int i=0; i<n; i++){
            Map<String, Integer> mp = new HashMap<>();
            int max = 0;
            for(int j = i+1; j<n; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;
                if(dx < 0 || (dx == 0 && dy < 0)){
                    dx = -dx;
                    dy = -dy;
                }
                String slope = dy + "/" + dx;
                mp.put(slope, mp.getOrDefault(slope, 0)+1);
                max = Math.max(max, mp.get(slope));
            }
            result = Math.max(result, max + 1);
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][2];
        for(int i=0; i<num; i++){
            for(int j=0; j<2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxPoints(arr));
        sc.close();
    }
}

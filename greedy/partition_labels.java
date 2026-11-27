package greedy;

/* 
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.


Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:

Input: s = "eccbbbbdec"
Output: [10]
*/

import java.util.*;

public class partition_labels {

    public static List<Integer> partitionLabels(String s){
        List<Integer> partition = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            int startIndex = i;
            int endIndex = s.lastIndexOf(s.charAt(startIndex));

            for(int j=startIndex+1; j<=endIndex-1; j++){
                int nextCharIndex = s.lastIndexOf(s.charAt(j));
                if(nextCharIndex > endIndex)
                    endIndex = nextCharIndex;
            }
            partition.add(endIndex-startIndex+1);
            i = endIndex;
        }

        return partition;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<Integer> result = partitionLabels(s);
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
        sc.close();
    }

}

package greedy;

/* 

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.


Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

*/

import java.util.*;

public class hand_of_straights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h: hand){
            map.put(h, map.getOrDefault(h, 0)+1);
        }

        while(!map.isEmpty()){
            int first = map.firstKey();
            for(int i=0; i<groupSize; i++){
                int next = first + i;
                if(!map.containsKey(next))
                    return false;
                
                int count = map.get(next);
                if(count == 1)
                    map.remove(next);
                else
                    map.put(next, map.get(next)-1);
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num; i++)
            arr[i] = sc.nextInt();
        int groupSize = sc.nextInt();
        System.out.println(isNStraightHand(arr, groupSize));
        sc.close();
    }
    
}

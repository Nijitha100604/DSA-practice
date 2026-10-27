/* 

Problem: Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:

Input: n = 2
Output: false
 

Constraints:

1 <= n <= 231 - 1
*/
import java.util.Scanner;

public class happy_number {

    public static int sum(int num){
        int value = 0;
        while(num != 0){
            value = value + ((num%10) * (num%10));
            num /= 10;
        }
        return value;
    }

    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = sum(slow);
            fast = sum(sum(fast));
        } while(slow != fast);

        if(slow == 1)
            return true;
        return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        System.out.println("IsHappy: "+ isHappy(inp));
        sc.close();
    }

}

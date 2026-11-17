/* 
Palindrome

Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
*/

// solution

import java.util.Scanner;

public class palindrome{

    public static boolean isPalindrome(int num){
        if(num < 0)
            return false;
        long rev = 0;
        int num1 = num;
        while(num1 != 0){
            int digit = num1 % 10;
            rev = (rev*10)+digit;
            num1 = num1/10;
        }
        if(rev == num)
            return true;
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        if(isPalindrome(num)){
            System.out.println(num + " is a palindrome");
        } else{
            System.out.println(num + " is not a palindrome");
        }

        sc.close();
    }

}
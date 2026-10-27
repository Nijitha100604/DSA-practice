/* 

Problem: Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1

*/
import java.util.Scanner;

public class reverse_integer {

    public static int reverse(int x){
        boolean isNegative = (x<0);
        long num = Math.abs((long)x);
        long rev = 0;
        while(num != 0){
            rev = rev*10 + (num%10);
            num = num / 10;
        }
        
        if(isNegative)
            rev = -1*rev;

        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)rev;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        System.out.println(reverse(inp));
        sc.close();
    }

}

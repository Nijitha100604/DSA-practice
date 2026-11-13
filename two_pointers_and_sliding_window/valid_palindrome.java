package two_pointers_and_sliding_window;

/* 
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

*/

import java.util.*;

public class valid_palindrome {

    public static boolean isPalindrome(String s) {
        if(s.length() == 1)
            return true;
        int low = 0;
        int right = s.length() - 1;

        while(low < right){
            while(low < right && !Character.isLetterOrDigit(s.charAt(low))) 
                low++;
            while(low < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            if(Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(right)))
                return false;
            low++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
        sc.close();
    }
}

package greedy;

/* 
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "(*)"
Output: true

Example 3:

Input: s = "(*))"
Output: true

Example 4:

Input: s = "("
Output: false
*/

import java.util.*;

public class valid_parenthesis_string {

    public static boolean checkValidString(String s){
        int minOpen = 0;
        int maxOpen = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                minOpen++;
                maxOpen++;
            }
            else if(ch == ')'){
                maxOpen--;
                minOpen--;
            }
            else{
                maxOpen++;
                minOpen--;
            }
            if(maxOpen < 0)
                return false;
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(checkValidString(s));
        sc.close();
    }

}


package stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Example 4:

Input: s = "([])"
Output: true

Example 5:

Input: s = "([)]"
Output: false
*/

import java.util.*;

public class valid_parentheses {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else{
                if(stack.isEmpty()) 
                    return false;

                if(ch == '}'){
                    if(stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                }

                if(ch == ']'){
                    if(stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                }

                if(ch == ')'){
                    if(stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isValid(s));
        sc.close();
    }
}

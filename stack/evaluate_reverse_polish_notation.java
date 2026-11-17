package stack;

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22 
*/

import java.util.*;

public class evaluate_reverse_polish_notation {

    public static int calculate(int num1, int num2, String op){
        switch(op)
        {
            case "+":
                return num1 + num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
            case "-":
                return num1 - num2;
        }
        return 0;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int num2 = 0;
                int num1 = 0;
                if(!stack.isEmpty()) 
                    num2 = stack.pop();
                
                if(!stack.isEmpty())
                    num1 = stack.pop();
                
                int val = calculate(num1, num2, tokens[i]);
                stack.push(val);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }

        }
        return stack.peek();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] arr = new String[num];
        for(int i=0; i<num; i++)
            arr[i] = sc.next();
        System.out.println(evalRPN(arr));
        sc.close();
    }

}

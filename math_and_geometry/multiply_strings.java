
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
*/

import java.util.*;

public class multiply_strings {

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";

        int[] product = new int[num1.length() + num2.length()];
        
        for(int i=num1.length() - 1; i>=0; i--){
            for(int j = num2.length() - 1; j>=0; j--){
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int mul = d1*d2;

                int posLow = i+j+1;
                int posHigh = i+j;

                int sum = mul + product[posLow];

                product[posLow] = sum%10;
                product[posHigh] += sum/10;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int num: product){
            if(!(res.length() == 0 && num==0)){
                res.append(num);
            }
        }

        return res.length() == 0 ? "0" : res.toString();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        System.out.println(multiply(num1, num2));
        sc.close();
    }

}

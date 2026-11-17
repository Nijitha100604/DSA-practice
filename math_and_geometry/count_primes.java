/*
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:

Input: n = 0
Output: 0

Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106
*/

// Sieve of Eratosthenes solution

import java.util.Scanner;

class count_primes{

    public static int countPrimes(int n) {
        if(n <= 2)
            return 0;
        boolean[] composites = new boolean[n];
        int limit = (int)Math.sqrt(n);

        for(int i = 2; i <= limit; i++){
            if(composites[i] == false){
                for(int j = i*i; j < n; j+=i)
                    composites[j] = true;
            }
        }

        int count = 0;
        for(int i=2; i<n; i++)
        {
            if(composites[i] == false)
               count++;
        }

        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        System.out.println(countPrimes(inp));
        sc.close();
    }
}
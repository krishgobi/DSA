/*
Question: Fibonacci Using Memoization (Dynamic Programming)

Description:
Find the nth Fibonacci number using memoization.

Fibonacci series:
0 1 1 2 3 5 8 13 ...

Formula:
fib(n) = fib(n-1) + fib(n-2)

--------------------------------------------------

Input:
n = 10

Output:
55

Explanation:
Fibonacci sequence up to n = 10:

0 -> 0
1 -> 1
2 -> 1
3 -> 2
4 -> 3
5 -> 5
6 -> 8
7 -> 13
8 -> 21
9 -> 34
10 -> 55

So, fib(10) = 55

--------------------------------------------------

Memoization:
Store already calculated Fibonacci values
to avoid repeated recursive calls.

This reduces time complexity from:
O(2^n) -> O(n)

--------------------------------------------------
*/

import java.util.*;

public class Main
{
    static int count = 0;

    static int[] mem;

    public static int fun(int n){

        count++;

        // Already calculated
        if(mem[n] != -1){

            return mem[n];
        }

        // Base cases
        if(n == 0){

            mem[n] = 0;

            return 0;
        }

        if(n == 1){

            mem[n] = 1;

            return 1;
        }

        // Store result
        mem[n] = fun(n - 1) + fun(n - 2);

        return mem[n];
    }

	public static void main(String[] args) {

		int n = 10;

		mem = new int[n + 1];

		Arrays.fill(mem, -1);

		System.out.println(fun(n) + " count is: " + count);
	}
}
// /*
// ------------------------------------------------------------
// Problem: Get Maximum in Generated Array
// ------------------------------------------------------------

// Description:
// Given an integer n, generate an array nums of size n + 1
// using the following rules:

// nums[0] = 0
// nums[1] = 1

// For every integer i such that:
// 2 <= 2*i <= n
//     nums[2*i] = nums[i]

// For every integer i such that:
// 2 <= 2*i + 1 <= n
//     nums[2*i + 1] = nums[i] + nums[i + 1]

// Return the maximum integer in the array nums.

// ------------------------------------------------------------
// Input:
// n = 7

// Output:
// 3

// Explanation:
// Generated array:
// [0, 1, 1, 2, 1, 3, 2, 3]

// Maximum value = 3



import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int n=7;
		int max=1;
		int[] nums=new int[n+1];
		nums[0]=0;
		nums[1]=1;
		for(int i=1;2*i<=n;i++){
		    nums[2*i]=nums[i];
		    max=Math.max(max,nums[2*i]);
		    if(2*i + 1 <= n){
		    nums[(2*i)+1]=nums[i]+nums[i+1];
		    max=Math.max(max,nums[(2*i)+1]);
		    }
		}
		
		System.out.print(max);
	}
}
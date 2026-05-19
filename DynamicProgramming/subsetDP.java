/*
Question: Subset Sum Problem

Description:
You are given:
1. An array of integers
2. A target sum

Find whether a subset exists whose sum is equal to the target.
Also print one possible subset.

Condition:
- Each element can be used only once.

--------------------------------------------------

Test Case 1

Input:
arr = [2,3,5,7,10]
sum = 14

Output:
[7, 5, 2]

Explanation:
7 + 5 + 2 = 14

So subset sum is possible.

--------------------------------------------------

Test Case 2

Input:
arr = [1,4,6,8]
sum = 10

Output:
[6, 4]

Explanation:
6 + 4 = 10

So subset sum is possible.

--------------------------------------------------
*/

//subset problem
import java.util.*;

public class Main
{
	public static void main(String[] args) {

	    int[] arr = {2,3,5,7,10};

	    int sum = 14;

	    int[][] dp = new int[arr.length][sum+1];

	    // Sum 0 is always possible
	    for(int i=0;i<arr.length;i++){

	        dp[i][0]=1;
	    }

	    // First row initialization
	    for(int j=1;j<=sum;j++){

	        if(j==arr[0]){

	            dp[0][j]=1;
	        }
	    }

	    // Fill DP table
	    for(int i=1;i<arr.length;i++){

	        for(int j=1;j<=sum;j++){

	            // cannot take current element
	            if(j<arr[i]){

	                dp[i][j]=dp[i-1][j];
	            }

	            else{

	                // already possible without taking
	                if(dp[i-1][j]==1){

	                    dp[i][j]=1;
	                }

	                // check by taking current element
	                else{

	                    dp[i][j]=dp[i-1][j-arr[i]];
	                }
	            }
	        }
	    }

	    // Backtracking
	    int i=arr.length-1;

	    int j=sum;

	    int tot=0;

	    List<Integer> list=new ArrayList<>();

	    while(tot!=sum && i>=0 && j>=0){

	        // first row special case
	        if(i==0){

	            list.add(arr[i]);

	            tot+=arr[i];

	            break;
	        }

	        // element not taken
	        if(dp[i][j]==dp[i-1][j]){

	            i-=1;
	        }

	        // element taken
	        else{

	            list.add(arr[i]);

	            tot+=arr[i];

	            j=j-arr[i];

	            i--;
	        }
	    }

	    System.out.print(list);
	}
}
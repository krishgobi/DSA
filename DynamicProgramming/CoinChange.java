/*
Question: Coin Change Problem

Description:
You are given:
1. An array of coins
2. A target amount

Find the minimum number of coins required
to make the target amount.

You can use a coin multiple times.

If it is not possible to form the amount,
return -1.

--------------------------------------------------

Input:
coins = [1, 2, 5]

amount = 11

Output:
3

Explanation:
11 can be formed using:

5 + 5 + 1 = 11

Total coins used = 3

--------------------------------------------------

Example 2

Input:
coins = [2]

amount = 3

Output:
-1

Explanation:
3 cannot be formed using coin 2.

--------------------------------------------------

Dynamic Programming Idea:

dp[i] =
minimum coins needed to make amount i

Transition:

dp[i] = min(dp[i], dp[i - coin] + 1)

--------------------------------------------------

Time Complexity:
O(amount * number of coins)

Space Complexity:
O(amount)

--------------------------------------------------
*/

import java.util.*;


public class Main
{
	public static void main(String[] args) {
		int[] coins={1,2,5,10};
		int amount=10;
		int[][] dp=new int[coins.length][amount+1];
		for(int i=0;i<coins.length;i++){
		    dp[i][0]=1;
		}
		for(int j=1;j<=10;j++){
		    if(j%coins[0]==0){
		        dp[0][j]=1;
		    }
		    else{
		        dp[0][j]=0;
		    }
		}
		for(int i=1;i<coins.length;i++){
		    for(int j=1;j<=amount;j++){
		        if(j<coins[i]){
		            dp[i][j]=dp[i-1][j];
		        }
		        else{
		            dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
		        }
		    }
		}
		System.out.print(dp[coins.length-1][amount]);
	}
}
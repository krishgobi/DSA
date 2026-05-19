/*
Question: Minimum Number of Coins to Make the Amount

Description:
You are given:
1. An array of coin denominations
2. A target amount

Find:
1. Minimum number of coins needed to make the amount
2. Which coins were used

You can use a coin multiple times.

--------------------------------------------------

Test Case 1

Input:
coins = [1,3,5]
amount = 9

Output:
3
[3, 3, 3]

Explanation:
9 can be formed using:

3 + 3 + 3

Minimum coins needed = 3

--------------------------------------------------

Test Case 2

Input:
coins = [1,2,5]
amount = 11

Output:
3
[5, 5, 1]

Explanation:
11 can be formed using:

5 + 5 + 1

Minimum coins needed = 3

--------------------------------------------------
*/

//Minimum Number of coins to make the amount
import java.util.*;

public class Main
{
	public static void main(String[] args) {

		int[] coins = {1,3,5};

		int amount = 9;

		int[][] dp = new int[coins.length][amount + 1];

		for(int i = 0; i < coins.length; i++){

		    dp[i][0] = 0;
		}

		for(int j = 1; j <= amount; j++){

		    if(j % coins[0] == 0){

		        dp[0][j] = j/coins[i];
		    }
		    else{

		        dp[0][j] = 10000;
		    }
		}

		for(int i = 1; i < coins.length; i++){

		    for(int j = 1; j <= amount; j++){

		        if(j < coins[i]){

		            dp[i][j] = dp[i - 1][j];
		        }
		        else{

		            dp[i][j] =
		            Math.min(
		                dp[i - 1][j],
		                1 + dp[i][j - coins[i]]
		            );
		        }
		    }
		}
        

		System.out.print(dp[coins.length - 1][amount]);

		List<Integer> list = new ArrayList<>();

		int dup_amount = amount;

		int i = coins.length - 1;

		int j = amount;

		while(dup_amount != 0 && i >= 0){

		    if(i == 0){

		        list.add(coins[i]);

		        dup_amount -= coins[i];

		        j -= coins[i];

		        continue;
		    }

		    if(dp[i][j] == dp[i - 1][j]){

		        i -= 1;
		    }

		    if(dp[i][j] != dp[i - 1][j]){

		        list.add(coins[i]);

		        dup_amount -= coins[i];

		        j = j - coins[i];
		    }
		}

		System.out.print(list);
	}
}
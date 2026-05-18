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
    public static int coinChange(int[] coins, int amount){

        int[] dp = new int[amount + 1];

        // Fill with large value
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case
        dp[0] = 0;

        // Build DP array
        for(int i = 1; i <= amount; i++){

            for(int coin : coins){

                if(i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE){

                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If impossible
        if(dp[amount] == Integer.MAX_VALUE){

            return -1;
        }

        return dp[amount];
    }

	public static void main(String[] args) {

		int[] coins = {1,2,5};

		int amount = 11;

		System.out.println(coinChange(coins, amount));
	}
}
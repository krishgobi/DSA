/*
Question: 0/1 Knapsack Problem

Description:
You are given:
1. weights[] -> weight of each item
2. profits[] -> profit of each item
3. capacity  -> maximum capacity of bag

Find:
1. Maximum profit possible
2. Which items/weights were selected

Condition:
- Each item can be used only once
- Either take full item or do not take it

--------------------------------------------------

Test Case 1

Input:
weights = [3,4,6,5]
profits = [2,3,1,4]
capacity = 8

Output:
6
[4, 3]

Explanation:
Selected items:
Weight 4 -> Profit 3
Weight 3 -> Profit 2

Total Weight = 7
Total Profit = 5

But optimal solution:
Weight 5 -> Profit 4
Weight 3 -> Profit 2

Total Weight = 8
Total Profit = 6

Maximum Profit = 6

--------------------------------------------------

Test Case 2

Input:
weights = [1,3,4,5]
profits = [1,4,5,7]
capacity = 7

Output:
9
[4, 3]

Explanation:
Selected items:
Weight 4 -> Profit 5
Weight 3 -> Profit 4

Total Weight = 7
Total Profit = 9

--------------------------------------------------
*/

 // 0/1 Knapsack problem 
import java.util.*;

public class Main
{
	public static void main(String[] args) {

		int[] weights = {3,4,6,5};

		int[] profits = {2,3,1,4};

		int capacity = 8;

		int[][] dp = new int[weights.length + 1][capacity + 1];

		for(int i = 0; i < weights.length; i++){

		    for(int j = 0; j < weights.length - i - 1; j++){

		        if(weights[i] > weights[i + 1]){

		            int temp = weights[i];
		            weights[i] = weights[i + 1];
		            weights[i + 1] = temp;

		            int temp1 = profits[i];
		            profits[i] = profits[i + 1];
		            profits[i + 1] = temp1;
		        }
		    }
		}

		// Base case
		for(int i = 0; i <= weights.length; i++){

		    dp[i][0] = 0;
		}

		for(int j = 1; j <= capacity; j++){

		    dp[0][j] = 0;
		}

		// Fill DP table
		for(int i = 1; i <= weights.length; i++){

		    for(int j = 1; j <= capacity; j++){

		        if(j < weights[i - 1]){

		            dp[i][j] = dp[i - 1][j];
		        }

		        else{

		          dp[i][j] = Math.max(
		              dp[i - 1][j],
		              profits[i - 1] + dp[i - 1][j - weights[i - 1]]
		          );
		        }
		    }
		}

		System.out.print(dp[weights.length][capacity]);

		// Backtracking
		List<Integer> list = new ArrayList<>();

		int i = weights.length;

		int j = capacity;

		int dup_capacity = capacity;

		while(dup_capacity != 0 && i > 0){

		    // item not taken
		    if(dp[i][j] == dp[i - 1][j]){

		        i -= 1;
		    }

		    // item taken
		    else{

		        list.add(i);

		        dup_capacity -= weights[i - 1];

		        j = j - weights[i - 1];

		        i--;
		    }
		}

		System.out.println(list);
	}
}
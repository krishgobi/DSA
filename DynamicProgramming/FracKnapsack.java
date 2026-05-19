/*
Question: Fractional Knapsack Problem

Description:
You are given:
1. values[]   -> profit of items
2. weights[] -> weight of items
3. capacity  -> maximum bag capacity

You can take full item or fractional part of an item.

Find the maximum profit possible.

--------------------------------------------------

Test Case 1

Input:
values  = [60,100,120]
weights = [10,20,30]
capacity = 50

Output:
240.0

Explanation:

Value/Weight ratios:

60/10  = 6
100/20 = 5
120/30 = 4

Take item 1 completely:
profit = 60
capacity = 40

Take item 2 completely:
profit = 160
capacity = 20

Take 20/30 part of item 3:
profit += 80

Total Profit = 240.0

--------------------------------------------------

Test Case 2

Input:
values  = [10,5,15,7,6,18,3]
weights = [2,3,5,7,1,4,1]
capacity = 15

Output:
55.333333333333336

Explanation:

Take items with highest value/weight ratio first
to maximize profit.

--------------------------------------------------
*/

public class Main
{
	public static void main(String[] args) {

		int[] values = {60,100,120};

		int[] weights = {10,20,30};

		int capacity = 50;

		double[] ratio = new double[values.length];

		// Calculate value/weight ratio
		for(int i = 0; i < ratio.length; i++){

		    ratio[i] = (double) values[i] / weights[i];
		}

		// Sort by descending ratio
		for(int i = 0; i < ratio.length; i++){

		    for(int j = 0; j < ratio.length - i - 1; j++){

		        if(ratio[j] < ratio[j + 1]){

		            double temp = ratio[j];
		            ratio[j] = ratio[j + 1];
		            ratio[j + 1] = temp;

		            int temp1 = values[j];
		            values[j] = values[j + 1];
		            values[j + 1] = temp1;

		            int temp2 = weights[j];
		            weights[j] = weights[j + 1];
		            weights[j + 1] = temp2;
		        }
		    }
		}

		double profit = 0;

		int i = 0;

		// Pick items greedily
		while(capacity != 0 && i < ratio.length){

		    // Take full item
		    if(capacity >= weights[i]){

		        profit += values[i];

    		    capacity -= weights[i];

    		    i++;
		    }

		    // Take fractional part
		    else{

		        profit +=
		        ((double) capacity / weights[i]) * values[i];

		        capacity = 0;
		    }
		}

		System.out.print(profit);
	}
}
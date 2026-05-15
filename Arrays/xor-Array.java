/*
------------------------------------------------------------
Problem: Cyclic Array Prefix XOR Sum
------------------------------------------------------------

Description:
You are given an array ARR.

Construct a new array RES using the following rules:

1. Start from any index of ARR.
2. Choose a direction (left or right).
3. Traverse the array cyclically.
4. Add traversed elements into RES.

The value of RES is defined as:
Sum of XOR values of all prefixes.

------------------------------------------------------------
Input:
ARR = [1, 2, 3, 4, 5]

Start Index:
3

Direction:
LEFT

------------------------------------------------------------
Constructed RES:

Start from index 3 → value = 4

Move left cyclically:
4 → 3 → 2 → 1 → 5

RES = [4, 3, 2, 1, 5]

------------------------------------------------------------
Prefix XOR Calculation:

Prefix 1:
4
XOR = 4

Prefix 2:
4 ^ 3 = 7

Prefix 3:
4 ^ 3 ^ 2 = 5

Prefix 4:
4 ^ 3 ^ 2 ^ 1 = 4

Prefix 5:
4 ^ 3 ^ 2 ^ 1 ^ 5 = 1

------------------------------------------------------------
Final Sum:

4 + 7 + 5 + 4 + 1 = 21

Output:
21

------------------------------------------------------------
Time Complexity:
O(n)

Space Complexity:
O(n)
------------------------------------------------------------
*/

public class Main
{
	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5};

		int[] arr = new int[nums.length];

		int i = 3;

		int m = 0;

		// Traverse left from chosen index
		for(int j = i; j >= 0; j--) {

		    arr[m] = nums[j];

		    m++;
		}

		// Continue cyclic traversal
		for(int j = nums.length - 1; j > i; j--) {

		    arr[m] = nums[j];

		    m++;
		}

		int sum = 0;

		int xor = 0;

		// Calculate prefix XOR sum
		for(int j = 0; j < arr.length; j++) {

		    xor = xor ^ arr[j];

		    sum += xor;
		}

		System.out.println(sum);
	}
}ß
/*
Question: Minimum Number of Operations to Make Array Empty

Input:
arr = [2, 2, 3, 3, 1]

Output:
3

Explanation:
Remove (2,3)
Remaining -> [2,3,1]

Remove (2,3)
Remaining -> [1]

Remove (1)

Total operations = 3
*/

import java.util.*;

public class Main
{
	public static void main(String[] args) {

		int[] arr = {2,2,3,3,1};

		HashMap<Integer,Integer> map = new HashMap<>();

		for(int num : arr) {

		    map.put(num, map.getOrDefault(num,0) + 1);
		}

		int max = 0;

		for(int freq : map.values()) {

		    max = Math.max(max, freq);
		}

		int half = (arr.length + 1) / 2;

		if(max > half) {

		    System.out.print(max);
		}
		else {

		    System.out.print(half);
		}
	}
}
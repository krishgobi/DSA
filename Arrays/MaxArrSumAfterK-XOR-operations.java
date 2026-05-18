/*
Question: Maximize Array Sum Using XOR Operation

Description:
You are given:
1. An array A of size N
2. An integer X
3. An integer K

You can perform the following operation at most K times:

Choose an element A[i] and replace it with:
A[i] ^ X

(^ represents XOR operation)

Find the maximum possible sum of the array.

--------------------------------------------------

Input:
N = 5
K = 2

A = [1, 2, 3, 4, 5]

X = 4

--------------------------------------------------

Explanation:

Original Sum:
1 + 2 + 3 + 4 + 5 = 15

After XOR with X = 4:

1 ^ 4 = 5   -> gain = +4
2 ^ 4 = 6   -> gain = +4
3 ^ 4 = 7   -> gain = +4
4 ^ 4 = 0   -> gain = -4
5 ^ 4 = 1   -> gain = -4

Choose the best K = 2 gains:
+4 and +4

Maximum Sum:
15 + 4 + 4 = 23

--------------------------------------------------

Output:
23
*/

import java.util.*;

public class Main
{
    public static long solve(int N,int K,int X,int[] A){

        long sum = 0;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){

            sum += A[i];

            int curr = A[i] ^ X;

            int diff = curr - A[i];

            // Store only positive gains
            if(diff > 0){

                list.add(diff);
            }
        }

        // Sort gains in descending order
        Collections.sort(list, Collections.reverseOrder());

        // Add top K gains
        for(int i = 0; i < Math.min(K, list.size()); i++){

            sum += list.get(i);
        }

        return sum;
    }

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int K = sc.nextInt();

		int[] A = new int[N];

		for(int i = 0; i < N; i++){

		    A[i] = sc.nextInt();
		}

		int X = sc.nextInt();

		long result = solve(N, K, X, A);

		System.out.print(result);
	}
}
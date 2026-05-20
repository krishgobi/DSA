// Longest Common Subsequence (LCS) using Dynamic Programming

/*
Problem Statement:
Given two strings str1 and str2, find:

1. Length of the Longest Common Subsequence (LCS)
2. The subsequence itself

A subsequence maintains order but characters do not need to be contiguous.

--------------------------------------------------

Example 1:

Input:
str1 = "abcde"
str2 = "ace"

Output:
3 ace

Explanation:
The longest common subsequence is "ace"
Length = 3

--------------------------------------------------

Example 2:

Input:
str1 = "abaaba"
str2 = "babbab"

Output:
4 baba

Explanation:
The longest common subsequence is "baba"
Length = 4

--------------------------------------------------

Approach:
1. Create a DP table.
2. If characters match:
      dp[i][j] = 1 + dp[i-1][j-1]
3. Else:
      dp[i][j] = max(dp[i-1][j], dp[i][j-1])
4. Backtrack from dp[n][m] to find the subsequence.

Time Complexity: O(N*M)
Space Complexity: O(N*M)
*/

public class Main
{
	public static void main(String[] args) {
		
		String str1="abaaba";
		String str2="babbab";

	    int[][] dp=new int[str1.length()+1][str2.length()+1];

	    // Base conditions
	    for(int i=0;i<=str2.length();i++){
	        dp[0][i]=0;
	    }

	    for(int j=0;j<=str1.length();j++){
	        dp[j][0]=0;
	    }

	    // Filling DP table
	    for(int i=1;i<=str2.length();i++){

	        for(int j=1;j<=str1.length();j++){

	            // Characters match
	            if(str2.charAt(i-1)==str1.charAt(j-1)){

	                dp[i][j]=1+dp[i-1][j-1];
	            }

	            // Characters do not match
	            else{

	                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
	            }
	        }
	    }

	    // Printing LCS length
	    System.out.print(dp[str1.length()][str2.length()]+" ");

	    // Backtracking to find subsequence
	    StringBuilder res=new StringBuilder();

	    int i=str1.length();
	    int j=str2.length();

	    while(i > 0 && j > 0){

            // Character matches
            if(str1.charAt(i-1) == str2.charAt(j-1)){

                res.append(str1.charAt(i-1));

                i--;
                j--;
            }

            // Move upward
            else if(dp[i-1][j] > dp[i][j-1]){

                i--;
            }

            // Move left
            else{

                j--;
            }
        }

	    // Reverse because characters were collected backwards
	    System.out.println(res.reverse().toString());
	}
}
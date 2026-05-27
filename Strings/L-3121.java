Leetcode: 3121 Count the Number of Special Characters II

You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

There are no special characters in word.

Example 3:

Input: word = "AbBCab"

Output: 0

Explanation:

There are no special characters in word.

 
class Solution {
    public int numberOfSpecialChars(String word) {
       int[] arr1=new int[26];
       int[] arr2=new int[26];
       Arrays.fill(arr1,0);
       Arrays.fill(arr2,0);
       for(int i=0;i<word.length();i++){
        char ch=word.charAt(i);
        if(ch>='a' && ch<='z'){
            arr1[ch-'a']=i+1;
        }
        else{
            if(!(arr2[ch-'A']>0)){
            arr2[ch-'A']=i+1;
            }
            else{
                continue;
            }
        }
       }
       int max=0;
       int i=0;
       while(i<=25){
        if(arr1[i]>0 && arr2[i]>0){
            if(arr1[i]<arr2[i]){
                max++;
            }
        }
        i++;
       }
       return max;
    }
}
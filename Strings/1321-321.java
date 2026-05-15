// /*
// ------------------------------------------------------------
// Problem: Remove Digit From Number to Maximize Result
// ------------------------------------------------------------

// Description:
// You are given:
// 1. A string number representing a positive integer.
// 2. A character digit.

// Remove exactly one occurrence of digit from number
// such that the resulting number becomes maximum.

// Return the maximum value possible after removal.

// ------------------------------------------------------------
// Input:
// number = "5678"
// digit  = "5"

// Output:
// 678

// Explanation:
// Removing '5' from "5678" gives:
// "678"

// This is the maximum possible value.
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your number:");
		String number=sc.next();
		System.out.println("Enter the digit:");
		String  digit=sc.next();
		int out=0;
		for(int i=0;i<number.length();i++){
		    if(digit.charAt(0)==number.charAt(i)){
		        String res="";
		        res+=number.substring(0,i);
		        res+=number.substring(i+1);
		        int num=Integer.parseInt(res);
		        res="";
		        if(num>out){
		            out=num;
		        }
		    }
		    else{
		        continue;
		    }
		}
		System.out.print(out);
	}
}
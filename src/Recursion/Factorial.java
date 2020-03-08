package Recursion;

import java.util.Scanner;

class Factorial {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("enter n: ");
		int n=in.nextInt();
		System.out.println(n+"! = "+fact(n));
	}
	
	public static int fact(int num)
	{
		if(num==0)
			return 1;
		else
			return num*fact(num-1);
	}

}

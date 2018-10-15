package com;

import java.util.Arrays;

public class Recurssion {

	public static void main(String[] args) {

		
	int[] arr = new int[] {1,2,3,4,5,6};
		
	//int result=	sum(4);
	//System.out.println(result);
		
	//int data=powerOfTen(6);	
	//System.out.println(data);	
	
	
	int n =arr.length-1;  //end of the aray
	int [] darray= reverseArray(arr,n);
	
	Arrays.stream(darray).forEach(System.out::println);
	
	
	//reverse array, start, end
	reverse(arr, 0, arr.length -1);
	
	System.out.println(Arrays.toString(arr));
	
	

	}
	
	
	public static int[] reverseArray(int[] ary,int n) {
		
        if(n >= 0) {
            System.out.print(ary[n]);
            reverseArray(ary, n - 1);  //remember to use n-1
        }
		return ary;
		
		
	}
	
	
	public static int[] reverse(int[] ary,int start, int end) {
		

		if (start<end) {
			
			
			swap(ary, start, end);
			reverse(ary, ++start, --end);
		}
		return ary;
		
		
	}
	
	
	public static int[] swap(int[] arr,int x, int y) {
		
		arr[x]=arr[x]^arr[y];
		arr[y]=arr[x]^arr[y];
		arr[x]=arr[x]^arr[y];
		return arr;
		
	}
	
	
	
	//recursive sum from 0 to n
	
	public static int sum(int n) {
		
		
		if (n==0) {
			
			return 0;
		}
		if(n>=1) {
			
			
			//return the previous numbers calculatoin and add the current number
			return sum(n-1)+n;
			
		}
		
		else {
			
			return n;
		}
	
		
	}

	
	
	public static int powerOfTen(int n) {
		
		
		if (n==0) {
			System.out.println(" BASE CASE: the current value is: "+n);
			return 1;
		}
		
		else {
			
			System.out.println("the current value is: "+n +"  and the data returned is: "+(n-1) *10);
			
			return powerOfTen(n-1) *10;
		}
		
		
		
		
		
		
		
	}
	
	
	

}



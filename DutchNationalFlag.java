package com;

public class DutchNationalFlag {
 
    /**
     *  Start with three pointers : reader, low and high.
		reader and low are initialized as 0 and high is initialized as last element of array as size-1.
		reader will be used to scan the array while low and high will be used to swap elements to their desired positions.
		Starting with current position of reader, follow below steps, keep in mind we need 0 at start of array
		If element at index reader is 0, swap element at reader with element at low and increment low and reader by 1.
		If element at reader is 1, do not swap and increment reader by 1.
		If element at reader is 2, swap element at reader with element at high and decrease high by 1
		
		
		(1) Create a low pointer at the beginning of the array and a high pointer at the end of the array.
		(2) Create a mid pointer that starts at the beginning of the array and iterates through each element.
		(3) If the element at arr[mid] is a 2, then swap arr[mid] and arr[high] and decrease the high pointer by 1.
		(4) If the element at arr[mid] is a 0, then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
		(5) If the element at arr[mid] is a 1, don't swap anything and just increase the mid pointer by 1.
				
		https://betterexplained.com/articles/swap-two-variables-using-xor/
		
		https://www.algorithmsandme.com/dutch-national-flag-algorithm/
		
		https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html
		
     * @param input
     * @param i
     * @param j
     * 
     *   .sorted(Comparator.reverseOrder())
     */
	
	
	//using temp
	
	public static void swap(int[] arr, int a, int b){

		arr[a]= arr[a]^arr[b];
		arr[b]= arr[a]^arr[b];
		arr[a]= arr[a]^arr[b];
		
    }
	
	public static void swapper(int[] arr, int i, int j) {
	    arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
	}
 
    public static void dutchNationalFalgAlgorithm(int [] input){
 
		//pivot and low are initialized as 0 and high is initialized as last element of array as size-1.
		//pivot will be used to scan the array while low and high will be used to swap elements to their desired positions.
        int pivot = 0;
        int low = 0;
        int high = input.length - 1;
 
        while(pivot <= high){
            /*
              input always holds a permutation of the original data with input(0..(lo-1)) =0, input(lo..(reader-1))=1, input(reader..hi) is 
              untouched, and input((hi+1)..(input.length-1)) = 2
            */
            if(input[pivot] == 0){
                /*this implies it is 0:0, so move the zero to the low partition and increment both the pivot and the low*/
                swap(input, pivot, low);
                pivot++;
                low++;
            }
            else if(input[pivot] == 1){
                /* if element at pivot is just  1
                increment reader by 1. We dont have to do any operations because this is in the middle */
                pivot++;
            }
            else if(input[pivot] == 2){
                /* If element at pivot is 2, swap
                 element at pivot with element at
                 high and decrease high by 1 because we will have to add to it at the end */
                swap(input, pivot, high);
                high--;
            }
            else{
               System.out.println("Bad input");
               break;
            }
        }
 
    }
    public static void main(String[] args) {
        int[] input = {2,2,1,1,0,0,0,1,1,2};
 
        
       // swap(input,0,0);
       dutchNationalFalgAlgorithm(input);
        
        
        
 
        for(int i=0; i<input.length; i++){
            System.out.print(" " + input[i]);
        }
    }
}
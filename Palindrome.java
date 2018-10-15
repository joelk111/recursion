package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Palindrome {

	
	private static AtomicLong id = new AtomicLong(0);
	
	public static long nextId() {
		long next = id.incrementAndGet();
		return next;
	}
	
	
	
	
	public static void main(String[] args) {
	
		// Scanner scan = new Scanner(System.in);
		 //String original = scan.nextLine();
		
		
		long uid =nextId();
		System.out.println(uid);
		
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		boolean test= isPalindromeUsingIntStream("TEST");
		System.out.println(test);
		
		

		
		
  	  int[] array = {23,43,56,97,32};
  	  Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s));
  	  Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));	
		
      List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
      long l = list.stream().distinct().count();
      System.out.println("No. of distinct elements:"+l);
      String output = list.stream().distinct().collect(Collectors.joining(","));
      System.out.println(output);
  	  
      Map<Boolean, List<Long>> result = IntStream.range(1, 10)
              .mapToObj(Long::new) //we have a IntStream of int and need to convert each entry to a Long.
              .collect(Collectors.partitioningBy(
                      i -> i % 2 == 0));
      System.out.println(result);
      

      
      //partition based on staring with A
      Predicate<String> startWithA = p -> p.startsWith("A");

      Map<Boolean, List<String>> decisionsByA = list.stream()
              .collect(Collectors.partitioningBy(startWithA));
      
      
      System.out.println(decisionsByA);
      
      int[] intArray = { 2, 4, 6, 8, 10 };
      int[] input = {3,4,1,5,7,9,12,1,6,2};
      
      swap(1, 2, intArray);
      
      
      
      
      
/*      for(int i=0; i<input.length; i++) {
    	  
    	//input[input.length-1] =17;
    	  
    	 int node =input[i];
    	 
    	 
    	 //if ( (x & 1) == 0 ) { even... } else { odd... }
    	 
    	 if((node &1)==0) {
    		 
    		// System.out.println(node + " is even");
    		 
    		 
    		 
    	 }
    	 

    	  
    	  
    	  
    	  
      }*/
      
      for(int i=0; i<input.length; i++){
          System.out.print(" " + input[i]);
      }
      
      
      
  	  
	}
	
	
	public static void swap(int i, int j, int[] arr) {
		   int t = arr[i];
		   arr[i] = arr[j];
		   arr[j] = t;
		   System.out.println(Arrays.toString(arr)); // print array passed in

		
		
	}
	
	
	
	
	public static Boolean isPalindromeUsingIntStream(String data) {
	    String strVal  = data.replaceAll("\\s+", "").toLowerCase();
	    boolean result = IntStream.range(0, strVal.length() / 2) //get each side  TE
	      .noneMatch(i -> strVal.charAt(i) != strVal.charAt(strVal.length() - i - 1));
	    
	    
	    return IntStream.range(0, strVal.length() / 2)
	      .noneMatch(i -> strVal.charAt(i) != strVal.charAt(strVal.length() - i - 1));
	}

	
	
	public List<String> getEvenIndexedStrings(String[] names) {
	    List<String> evenIndexedNames = IntStream
	      .range(0, names.length)
	      .filter(i -> i % 2 == 0)
	      .mapToObj(i -> names[i])
	      .collect(Collectors.toList());
	     
	    return evenIndexedNames;
	}
}

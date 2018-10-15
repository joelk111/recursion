package com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Primes {

	
	//https://www.baeldung.com/java-8-streams
	public static void main(String[] args) {

		//Streams represent a sequence of objects,
		
		//permutations("joel").parallel().collect(Collectors.toSet()).stream().sorted().forEach(System.out::println);
		
		//permutations("joel").parallel().forEach(System.out::println);
		
		boolean primetest =isPrime(9);
		System.out.println(primetest);
		
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

		
		Stream<String> streamBuilder =
				  Stream.<String>builder().add("a").add("b").add("c").build();
		
		
		

	List<String> emails = Arrays.asList("@joel.com", "michael@.com", "test@google.com", "jk@joel.com");

	Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");		
	
	// Compile regex as predicate
	// Apply predicate filter
	List<String> desiredEmails = emails.stream().filter(pattern.asPredicate()).collect(Collectors.<String>toList());

    List numbers = Arrays.asList(1,2,3);
	
	Stream<Integer> stream1 = numbers.stream();
    // Limit - return new stream of 3 elements
    System.out.println("--------Stream elements after limiting----------");
    stream1.limit(3).forEach((a) -> {
       System.out.println(a);
       stream1.close();
    });
	
	
	}
	
	
	
	//A prime number is a whole number greater than 1 whose only factors are 1 and itself.
	
	/**
	 * if it is greater than 1 and cannot be written as a product of two natural numbers that are both smaller than it. 
	 * @param data
	 * @return
	 * 
	 * The range(int startInclusive, int endExclusive) method creates an ordered stream from the first parameter to the second parameter. It increments the value of subsequent elements with the step equal to 1. The result doesn’t include the last parameter, it is just an upper bound of the sequence.

       The rangeClosed(int startInclusive, int endInclusive) method does the same with only one difference – the second element is included. These two methods can be used to generate any of the three types of streams of primitives.
	 * 
	 * 
	 */
	public static boolean isPrime(int number) {
	    return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
	}
	
	
/*	public static Stream<String> permutations(String str) {
		if (str.isEmpty()) {
		return Stream.of("");
		}
		return IntStream.range(0, str.length()).boxed()
		.flatMap(i -> permutations(str.substring(0, i) + str.substring(i + 1)).map(t -> str.charAt(i) + t));
		}*/
	
	
/**
 * If the String is empty: 
 * 
 * there are no characters, so the only result is a Stream that contains the empty String. 
 * This is the base case.
 * 
If the String is non-empty:

we remove the first character, build all the permutations without it and then prepend the first character to all the results.
then we remove the second character, build all the permutations without it and then prepend the second character to all the results.
etc. until we hit the last character
 * @param str
 * @return
 */
	public static Stream<String> permutations(String str) {
	    if (str.isEmpty()) {
	        return Stream.of("");
	    }
	    return IntStream.range(0, str.length())
	                .boxed() //returns the int as an Integer
	                .flatMap(i ->
	                  permutations(str.substring(0, i) + str.substring(i+1)).map(t -> str.charAt(i) + t)
	                );
	}

	
	public void iterateMapLambda(Map<String, Integer> map) {
	    map.forEach((k, v) -> System.out.println((k + ":" + v)));
	}
}

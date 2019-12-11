package com.mercury.java_core.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.mercury.java_core.oop.User;

public class TestStreamAPI {

	public static void main(String[] args) {
		Integer[] arr = { 1, 1, 2, 3, 4, 5 };

		// 1. remove duplicates {1, 2, 3, 4, 5};
		// 2. sort in descending order {5,4,3,2,1}
		// 3. double all numbers {10,8,6,4,2}
		// 4. remove all numbers which can divided by 3 {10,8,4,2}
		// 5. output 2 numbers from the 2nd one {8,4}

		// we may need 30+ lines if use for-loop
		// iteration: initiative approach

		// stream api: passive approach. data are dynamically flowing
		// 被动，让数据自己 flow
		System.out.println("------------   1     ------------");
		Stream<Integer> arrStream = Arrays.stream(arr);
		arrStream.distinct() // remove duplicate elements, return a Stream
//				.peek(i -> System.out.println(i)) // it will not terminate stream
				.sorted((i1, i2) -> i2 - i1) // use Lambda function to implement
												// comparator!!
												// descending order
				.map(i -> i * 2) // take Function as parameter
				.filter(i -> i % 3 != 0) // take Predicate as parameter, false
											// will be filter out
											// true will stay and go to next.
				.skip(1) // skip the first number
				.limit(2) // only out 2 numbers
				.forEach(i -> {
					System.out.println(i);
				});
		
		System.out.println("-------------    2      ----------");
		// Get min of the array
		Stream<Integer> arrStream1 = Arrays.stream(arr);
		int m = 0;
		Optional<Integer> minOp = arrStream1.min((i, j) -> i - j);
		// minOp will be empty if no min. Otherwise we can get min from minOp
		if (minOp.isPresent()) {
			System.out.println("min is arr: " + minOp.get());
			m = minOp.get();
		} else {
			System.out.println("no min in arr.");
			m = Integer.MIN_VALUE;
		}
		
		int n = minOp.orElse(Integer.MIN_VALUE); // if the minOp is empty, then give Integer.min
												// if the minOp is not, then assign value
												// same function less code as above
												// Better one.
		
		//-----------------------------------------------------------------------------------
		System.out.println("--------------  3      ----------");
		List<User> list = new ArrayList<>();
		list.add(new User("bob", 21));
		list.add(new User("alice", 25));
		list.add(new User("alex", 23));
		Stream<User> userStream = list.stream();
		// sort stream by User age
		// remove user whose age <= 21
		// change user's name to upperCase and double the age
		List<User> processedUsers = 
		userStream
				.sorted((u1, u2) ->  u1.getAge() - u2.getAge())
				.filter(u -> u.getAge() > 21 )
				.map(u ->  {
					u.setName(u.getName().toUpperCase());
					u.setAge(u.getAge() * 2);
					return u;	// because a Function must should return something
								// And here the .map function finally return a Stream so we 
								// can play with the stream
					// int 不需要写 return 是因为默认 return，一行代码就结束
					// 这里前面两个步骤都是在更改名字和年龄，最后再把更改后的一个 object
					// return。所以这里需要写 return。
				})
				.collect(Collectors.toList());	// Convert the Stream back to List
		System.out.println(processedUsers);
		
		
		//--------------------------------------------------------------------------------
		
		//Convert Users to Waiters
		System.out.println("----------   4  ---------");
		List<Waiter> waiters;
		Stream<User> userStream1 = list.stream();
		
		waiters = userStream1
			.map(u -> u.getName())			// get a stream of string name
			.map(name -> new Waiter(name))	// get a stream of waiters
			.peek(w -> System.out.println(w))
			.collect(Collectors.toList());
		
//		// below are method reference, the same result as above. But recommend above
//		waiters = userStream1
//				.map(User::getName)			// get a stream a string name
//				.map(Waiter::new)	// get a stream of waiters
//				.peek(System.out::println)
//				.collect(Collectors.toList());
		
			
		//-------------------------------------------------------------------------------
		
		// Primitive stream
		// int, float, double
		System.out.println("----------     5     -------------");
		int[] parr = {1, 2, 3};
		IntStream pstream = Arrays.stream(parr);
		OptionalInt oi = pstream.min();
		if(oi.isPresent()){
			System.out.println(oi.getAsInt());
		}
		
		System.out.println("-----------   6     ------------");
		String[][] array = {{"bob", "23", "45", "98"}, {"ben", "90"}, {"ketty", "78"}};
		System.out.println(getBestAverageScore(array));
	}
	
	public static int getBestAverageScore(String[][] array){
		if(array == null || array.length==0) return -1;
		
		Stream<String[]> myStream = Arrays.stream(array);
		double result = myStream
						.map((arr)->{
							return 	// ************
							Arrays.stream(arr)
							.skip(1)
							.mapToDouble(num -> Double.parseDouble(num)) //*******
							.average()
							.getAsDouble();	//**************
						})	.max((d1, d2) -> (int) (d1 - d2)) // ****
							.get();		// ******

		return (int)result;
	}

}










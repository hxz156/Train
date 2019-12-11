package com.mercury.java_core.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.mercury.java_core.oop.User;

public class TestFunctionalInterface {

	public static void main(String[] args) {
		// 不能直接 new 一个interface， 我们需要去 implement 一下, inner class。
		Flyable f = new Flyable(){
			@Override
			public void fly() {
				System.out.println("inner class Flyable");
			}
		};
		f.fly();
		
		// 下面的和上面作用一样，不过只能用在 functional interface 上面
		Flyable f1 = () -> {
			System.out.println("Another flyable, this is Lambda function");
		};
		f1.fly();
		
		// Lambda function 用在 comparator ：
		Comparator<User> comp = (o1, o2) -> o1.getAge() - o2.getAge();
		
		// Consumer
		// Consumer<T>, BiConsumer<T, U>: take 1 or 2 parameters, return void
		Consumer<Integer> consumer = i -> System.out.println(i);
		consumer.accept(10);
		
		// BiConsumer
		BiConsumer<Integer, Integer> sumBiConsumer = (i1, i2) -> 
		System.out.println(i1 + i2);
		sumBiConsumer.accept(1, 3);
		
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("bob", 90);
		hmap.put("alice", 92);
		hmap.put("alex", 93);
		
		// 3rd way to loop through a map, 利用 BiConsumer.
		// 因为 hmap.forEach() 会返回类型为 BiConsumer() 的东西
		System.out.println("------hmap.forEach((k, v)----------");
		hmap.forEach((k, v) -> {
			System.out.println(k + ": " + v);
		});
		
		// Test any number is odd number.
		// Predicate<T>, BiPredicate<T, U>: take 1 or 2 parameter, return Boolean
		Predicate<Integer> p = i -> i % 2 != 0;
		System.out.println(p.test(10));
		
		// Take no parameter, return number [0, 10]
		// Supplier<R>: take no parameter, return T
		Supplier<Integer> s = () -> (int)(Math.random() * 10);
		System.out.println(s.get());
		
		// Check Palindrome
		// Function(), example of Functional Interface
		// Function<T,R>, BiFunction<T,U,R>: take 1 or 2 parameters, return any type R.
		// R 就是 return 的 type
		Function<String, Boolean> checkPalindrome = str -> {
			for(int i=0; i<str.length(); i++){
				if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
					return false;
				}
			}
			return true;
		};
		System.out.println("-----checkPalindrome.apply-----");
		System.out.println(checkPalindrome.apply("abcba"));
		
		// BiFunction() take two parameters return one value
		BiFunction<String, Integer, String> repeatStringForNTimes = (str, n) ->{
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++){
				sb.append(str);
			}
			return sb.toString();
		};
		System.out.println(repeatStringForNTimes.apply("abcss", 10));
		
		// 和 Function<Integer, Integer> 效果一样
		UnaryOperator<Integer> doubleInt = i -> i * 2;
		System.out.println(doubleInt.apply(5));
		
		// 和 BiFunction<String, String, String> 效果一样
		BinaryOperator<String> concatStr = (s1, s2) -> (s1 + s2).toUpperCase();
		System.out.println(concatStr.apply("abc", "def"));
	}
}












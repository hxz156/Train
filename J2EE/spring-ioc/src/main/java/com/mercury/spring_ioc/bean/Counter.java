package com.mercury.spring_ioc.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // bean will be created only when the bean is used.
public class Counter {
	
	private static int count;
	
	public Counter() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
}












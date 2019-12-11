package com.mercury.spring_ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Autowired
//	@Qualifier("travelBook") // 必须指定哪一种书，因为有不同的书。
	Book book;

	@Override
	public String toString() {
		return "Student [book=" + book + "]";
	}
	
	
}

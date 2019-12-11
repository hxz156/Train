package com.mercury.spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mercury.spring_ioc.bean.CPU;
import com.mercury.spring_ioc.bean.Computer;
import com.mercury.spring_ioc.bean.Counter;
import com.mercury.spring_ioc.bean.Student;
import com.mercury.spring_ioc.config.SpringIoCConfig;

public class Test2 {

	public static void main(String[] args) {
		// using annotation
		ApplicationContext  ac =
				new AnnotationConfigApplicationContext(SpringIoCConfig.class);
		CPU cpu1 = (CPU)ac.getBean("cpu1");
		System.out.println(cpu1);
		
		// 默认成小写。
		Computer computer = (Computer)ac.getBean("computer");
		System.out.println(computer);
		
		// ============================================================
		Student s = (Student)ac.getBean(Student.class);
		System.out.println(s);
		
		
		// ============================================================
		// 1: 因为 Counter 被 @Component 扫描到，因为 eager,就创建了bean，用了 constructor,就会得到1.
		// 0: 因为 Counter 被设置成了 @Lazy,所以不会创建 bean
		System.out.println(Counter.getCount()); 
		ac.getBean(Counter.class);
		// 1: 因为 Counter 被调用了，所以 ++.
		System.out.println(Counter.getCount());
	}

}











package com.mercury.spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mercury.spring_ioc.bean.CPU;
import com.mercury.spring_ioc.bean.Computer;

public class Test1 {

	public static void main(String[] args) {
		
		// create a Spring container:
		ApplicationContext ac1 = 
				new ClassPathXmlApplicationContext("iocconfig.xml");
		
		CPU cpu1 = (CPU)ac1.getBean("cpu1");
		System.out.println(cpu1);
		
		// 两次调用，拿到的是一个对象。因为是 singleton.
		// change to prototype:
		// <bean id="cpu1" class="com.mercury.spring_ioc.bean.CPU" scope="prototype">
		CPU cpu11 = (CPU)ac1.getBean("cpu1");
		System.out.println(cpu11 == cpu1); // true
		
		//======================================================================
		
		// get an bean of type CPU.
		// if there are more than one CPU, expected single matching bean but found 2
//		CPU cpu = (CPU)ac1.getBean(CPU.class);
//		System.out.println(cpu);
		
		//======================================================================
		Computer computer1 = (Computer)ac1.getBean("computer1");
		System.out.println(computer1);
		
		
//		<bean id="computer3" class="com.mercury.spring_ioc.bean.Computer" autowire="byName">
//	    </bean>
		Computer computer3 = (Computer)ac1.getBean("computer3");
		System.out.println(computer3);
		
	}

}









package com.mercury.spring_ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mercury.spring_ioc.bean.CPU;

@Configuration
@ComponentScan(basePackages = {"com.mercury.spring_ioc.bean"}) // 指定地方扫描，得到bean
// 如果 @ComponentScan，不加(basePackages),只会在Config class 当前 package 扫描.

public class SpringIoCConfig {
	
	// === xml 里面的创建一个 bean, 但是这个也很麻烦，每一次都需要写，不如@Component
	@Bean(name="cpu1")
	// Spring 调用的方法：(Test2.java)
	public CPU getCPU1() {
		return new CPU("Intel", "i7");
	}
	
//	@Bean(name="cpu2")
//	public CPU getCPU2() {
//		return new CPU("AMD", "a3");
//	}
	
	// "cpu"
	// if name is not specified, it will use method name.
	@Bean()
	public CPU cpu() {
		return new CPU("Huawei", "h5");
	}
}




















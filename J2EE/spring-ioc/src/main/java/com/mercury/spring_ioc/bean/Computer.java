package com.mercury.spring_ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Computer {
	
//	@Autowired
//	@Qualifier("cpu1") // specific which CPU will be used. 因为有三个 CPU.
//	private CPU cpu;

	//-------------------------------------------------------------------------
	
//	@Inject === @Autowired. but Inject comes from JSR-330(J2EE Oracle), Autowired from Spring
//	or @Resource
	CPU cpu;
	
	public Computer() {
		super();
	}

	// @Autowired : 读取所有参数，按照类型分配。（也可以的方法之一）
	public Computer(CPU cpu) {
		super();
		this.cpu = cpu;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + "]";
	}
	
}

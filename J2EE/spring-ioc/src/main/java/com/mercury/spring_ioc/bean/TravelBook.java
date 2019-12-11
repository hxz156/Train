package com.mercury.spring_ioc.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary // 解决不同书，没有Qualifier, 默认就是这一个。
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TravelBook implements Book {
	
	@Value("China") // 给名字一个初始值。本来的值是 null.
	String name;
}

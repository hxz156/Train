package com.mercury.SpringBootRESTDemo.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// AOP 可以用来做 discount 功能。
@Aspect // change to aspect class
@Component
public class LogAllServiceMethodAspect {

	private final Logger logger = LoggerFactory.
			getLogger(LogAllServiceMethodAspect.class);
	@Pointcut("execution(* com.mercury.SpringBootRESTDemo.service.*Service.*(..))")
	public void getJoinPoint() {
		
	}
	@Before("getJoinPoint()")
	public void logBeforeServiceMethodAdvice(JoinPoint jp) {
		// print which service is invoked.
		logger.info(jp.getSignature().getName() + "was invoked at " + LocalDateTime.now());
	}
	
	// @Before, @AfterReturning, @AfterThrowing, @Around
	@Around("getJoinPoint()")
	public Object muteSampleMethods(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		if (pjp.getSignature().getName().contains("Sample")) {

		} else {
			try {
				System.out.println("***before method executes***");
				result = pjp.proceed();
				System.out.println("***after method executes***");
			} catch (Exception e) {
				System.out.println("***when method has exception***");
			} finally {
				System.out.println("***after method finally***");
			}
		}
		return result;
	}

}








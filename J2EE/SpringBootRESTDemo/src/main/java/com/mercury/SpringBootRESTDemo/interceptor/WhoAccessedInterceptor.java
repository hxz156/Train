package com.mercury.SpringBootRESTDemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// 在 Dispatcher 里面拦截请求，在传到 controller 之前拦截。
// 查看有谁在访问这个网址，记录下 ip 地址。
@Component
public class WhoAccessedInterceptor extends HandlerInterceptorAdapter {
	
	// 把日志在写进 file.
	private final Logger logger = LoggerFactory.getLogger(WhoAccessedInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 生成 info 级别的 日志。
		// debug 的时候，不用 sysout, 设置成 debug 级别。
		logger.info(request.getRemoteAddr() + " is trying to access your APIs!");
		return super.preHandle(request, response, handler);
	}

}












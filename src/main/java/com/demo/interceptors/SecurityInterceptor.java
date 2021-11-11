package com.demo.interceptors;



import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component("securityInterceptor")
public class SecurityInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getHeader("value1") != null) {
			String value1 = request.getHeader("value1");
			System.out.println("value1: " + value1);
		}
		if(request.getHeader("value2") != null) {
			int value2 = Integer.parseInt(request.getHeader("value2"));
			System.out.println("value2: " + value2);
		}
		String username="";
		String password="";
		if(request.getHeader("Authorization") != null) {
			String authorization = request.getHeader("Authorization");
			System.out.println("authorization: " + authorization);
			String hash = authorization.replace("Basic ", "");
			System.out.println("hash: " + hash);
			byte[] bytes = Base64.getDecoder().decode(hash);
			String usernameAndPassword = new String(bytes);
			System.out.println("usernameAndPassword: " + usernameAndPassword);
			String[] result = usernameAndPassword.split(":");
			 username = result[0];
			System.out.println("username: " + username);
			 password = result[1];
			System.out.println("password: " + password);
		}
		if(!username.isEmpty() && 
				!password.isEmpty() && 
				username.equalsIgnoreCase("abc") && 
				password.equalsIgnoreCase("123")) {
			return true;
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
	
}

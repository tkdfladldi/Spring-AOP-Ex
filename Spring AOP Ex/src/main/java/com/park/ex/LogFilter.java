package com.park.ex;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogFilter implements Filter{
	
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Log filter init");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("log filter dofilter");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestUri = httpRequest.getRequestURI();
		
		HttpServletResponse httpResponse =  (HttpServletResponse) response;
		
		try {
			System.out.println("인증 체크 필터 시작  : " + requestUri);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//String uuid = UUID.randomUUID().toString();
		
//		try {
//			System.out.println("REQUEST  = UUID :" +uuid +" requestURI : " +requestUri );
//			chain.doFilter(httpRequest, response);
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			System.out.println("RESPONSE  = UUID :" +uuid +" requestURI : " +requestUri );
//		}
	}

	@Override
	public void destroy() {
		System.out.println("log filter destroy");
	}

}

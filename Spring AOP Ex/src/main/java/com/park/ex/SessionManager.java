package com.park.ex;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

//세션 관리
@Component
public class SessionManager {

	 public static final String SESSION_COOKIE_NAME = "mySessionId";
	 private Map<String , Object> sessionStore = new ConcurrentHashMap<String, Object>();
	 
	 // 세션 생성
	 public void createSession(Object value , HttpServletResponse response) {
		 
		 String sessionId = UUID.randomUUID().toString();
		 
		 sessionStore.put(sessionId, value);
		 
		 Cookie  mySessionCookie =  new Cookie(SESSION_COOKIE_NAME, sessionId);
		 
		 response.addCookie(mySessionCookie);
	 }
	 // 세션 조회
	 public Object getSession(HttpServletRequest request ) {
		 
		 Cookie cookie = findCookie(request, SESSION_COOKIE_NAME);
		 
		 if(cookie == null) {
			 
			 return null;
		 }
		 return sessionStore.get(cookie.getValue());
	 }
	 //세션 만료
	 
	 public void expire(HttpServletRequest request, HttpServletResponse response) {
		 
		 Cookie sessionCookie = findCookie(request,SESSION_COOKIE_NAME);
		 
		 if(sessionCookie != null) {
			 sessionCookie.setMaxAge(0);
			 sessionStore.remove(sessionCookie.getValue());
			 response.addCookie(sessionCookie);
		 }
		 
	 }
	 // 세션 찾기
	 public Cookie findCookie(HttpServletRequest request ,String cookieName) {
		 
		 Cookie[] cookies = request.getCookies();
		 
		 if(cookies == null) {
			 return null;
		 }
		 for(Cookie cookie :  cookies) {
			 if(cookie.getName().equals(cookieName)) {
				 return cookie;
			 }
		 }
		 return null;
	 }
	
}

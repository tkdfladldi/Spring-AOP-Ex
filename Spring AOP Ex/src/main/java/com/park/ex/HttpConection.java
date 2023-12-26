package com.park.ex;

import java.applet.AppletContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore.Entry;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HttpConection {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HttpConection.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws MalformedURLException 
	 * @throws UnsupportedEncodingException 
	 */
	
	@ResponseBody
	@RequestMapping(value = "/httpConection", method = RequestMethod.GET)
	public String httpConection(HttpServletRequest request) throws MalformedURLException, UnsupportedEncodingException {
		  
		// getRequestURL 현재 요청 들어온 url 에서  getRequestURI 로 상세 uri 를 제거 한다음 getContextPath 프로젝트의 페스 경로를 마지막에 붙힌다
		String projectUrl = request.getRequestURL().toString().replace(request.getRequestURI(),"") + request.getContextPath();
		URL url = new URL(projectUrl+ "/httpConection");
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		JSONObject json = new JSONObject();
        json.put("name", "John Smith");
        json.put("age", 35);
        
        
//		map.put("sysTp", "sysTp"); 
//		map.put("serviceNm", "serviceNm");
//		map.put("slpNo", "slpNo");
//		map.put("menuCd", "menuCd");
//		map.put("iStgrd", "iStgrd");
//		map.put("iUname", "iUname");
//		map.put("iZzkostl", "iZzkostl");
//		map.put("userId", "userId");
//		
//		StringBuffer SbMap = new StringBuffer();
//		
//		for (Map.Entry<String, String> param : map.entrySet()) {
//			
//			if(SbMap.length() != 0) {
//				SbMap.append("&");
//			}
//			SbMap.append(param.getKey());
//			SbMap.append("=");
//			SbMap.append(param.getValue());
//		}
        
		byte[] dataByte = json.toString().getBytes("UTF-8");
		System.out.println("dataByte = "+ dataByte);
		String str = new String(dataByte, "UTF-8");
		System.out.println("String = "+ str);
		
		
		try {
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.getOutputStream().write(dataByte);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
			
			StringBuilder  sb = new StringBuilder();
			String text;
			while ((text = bufferedReader.readLine()) != null) {
				sb.append(text);
				
			}
			
			
			System.out.println(sb);
			
			httpUrlConnection.disconnect();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "main";
	}
	@ResponseBody
	@RequestMapping(value = "/httpConection", method = RequestMethod.POST)
	public void httpConectionPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  
		InputStream inputStream =  request.getInputStream();
		
		StringBuilder sbdata = new StringBuilder();
		int read;
		
		while ((read = inputStream.read()) != -1) {
			sbdata.append((char)read);
		}
		System.out.println("요청 들어온 값은 = " + sbdata);
		
		JSONObject json = new JSONObject(sbdata.toString());
		
		System.out.println("json age= " + json.get("age"));
		
		try {
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("안녕하세요");
			out.flush();
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/httpConectionTest", method = RequestMethod.POST)
	public String httpConectionTest(MultipartFile fileData , @RequestParam String fileName) throws IOException {
		
		
		System.out.println("asdas");
		
		return "main";
	}
	
}

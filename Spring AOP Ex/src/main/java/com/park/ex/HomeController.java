package com.park.ex;

import java.applet.AppletContext;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.T;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.Converter;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	RequestParamMethod requestParamMethod;
	
	@Autowired
	SessionManager sessionManager;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws InvalidPropertiesFormatException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) throws InvalidPropertiesFormatException, IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		String path = "session.xml";
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
		
		Properties properties = new Properties();
		
		properties.loadFromXML(inputStream);
		
		Enumeration<Object> key = properties.keys();
		while (key.hasMoreElements()) {
			String str = (String) key.nextElement();
			System.out.println(properties.get(str));
			
		}
		
		
		
		return "main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String GETlogin(@ModelAttribute MemberVo memberVo , BindingResult bidingresult,Model model) {

		
		return "home";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute MemberVo memberVo , BindingResult bidingresult,Model model , HttpServletRequest request ,HttpServletResponse response) {
		
		memberVo.setUserid("tkdfladldi");
		memberVo.setPassword(1234);
		
		request.getSession(true).setAttribute("mySessionId", memberVo);
		
		
		return "home";
	}
	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut(@ModelAttribute MemberVo memberVo , BindingResult bidingresult,Model model, HttpServletRequest request,HttpServletResponse response) {

		sessionManager.expire(request,response);
		
		return "home";
	}
	
	@RequestMapping(value = "/session-info", method = RequestMethod.GET)
	public String sessionInfo(@ModelAttribute MemberVo memberVo , BindingResult bidingresult,Model model, HttpServletRequest request,HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		
		if(session == null) {
			return "세션이 없습니다.";
		}
		Enumeration str = session.getAttributeNames();
		
		while (str.hasMoreElements()) {
			Object object = (Object) str.nextElement();
			System.out.println(object);
			
		}
		
		return "home";
	}
	@RequestMapping(value = "/servlet/v1/upload", method = RequestMethod.GET)
	public String getupload(HttpServletRequest request,HttpServletResponse response) {
		
		
		return "upload-form";
	}
	@RequestMapping(value = "/servlet/v1/upload", method = RequestMethod.POST)
	public String postupload(MultipartFile file ,HttpServletRequest request ) {
		
		String path = request.getSession().getServletContext().getRealPath("/");
		
		String itemName = request.getParameter("itemName");
		
		String str = file.getName();
		
		String st2r =file.getOriginalFilename();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream() , "UTF-8"));
			List<String> list = new ArrayList<>();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
			    list.add(line);
			}
			bufferedReader.close();

			String result = String.join("", list);
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "upload-form";
	}
	@RequestMapping(value = "/servlet/v2/upload", method = RequestMethod.GET)
	public String getupload2(HttpServletRequest request,HttpServletResponse response) {
		
		System.out.println("요청 ");
		
		return "upload-form2";
	}
	// 파일 전송하는곳 
	@RequestMapping(value = "/servlet/v2/upload", method = RequestMethod.POST)
	public String getupload2Post(@RequestParam("files") MultipartFile[] files, @RequestParam String itemName, HttpServletRequest request) throws IOException {
		
	    // 현재 프로젝트의 URL 경로를 가져옴
	    String projectUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "") + request.getContextPath();
	    // HTTP 프로토콜에서 줄바꿈을 표현하기 위한 문자열
	    String crlf = "\r\n";
	    // 멀티파트 폼 데이터에서 각 파트를 구분하기 위한 구분자 문자열
	    String twoHyphens = "--";
	    String boundary = "*****";

	    // 파일 전송을 위한 URL 생성 및 연결 객체 생성
	    URL url = new URL(projectUrl + "/FileSend");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setUseCaches(false);
	    conn.setDoOutput(true);
	    conn.setRequestMethod("POST");

	    // HTTP 요청 헤더 설정
	    conn.setRequestProperty("Connection", "Keep-Alive");
	    conn.setRequestProperty("Cache-Control", "no-cache");
	    conn.setRequestProperty("Accept-Charset", "UTF-8");
	    conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

	    // HTTP 요청 본문에 파일 데이터를 쓰기 위한 출력 스트림 생성
	    DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
	    
	    for(int i =0; i<files.length; i++) {
	    	
	    	MultipartFile file =  files[i];
	    	// 첫 번째 멀티파트 파트 작성 (파일 데이터)
	    	dos.write((twoHyphens + boundary + crlf).getBytes("UTF-8"));
	    	dos.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getOriginalFilename() + "\"" + crlf).getBytes("UTF-8"));
	    	dos.write(crlf.getBytes("UTF-8"));
	    	
	    	// 파일 데이터를 byte 배열로 변환하고 출력 스트림에 씀
	    	//ByteArrayInputStream fileInputStream = new ByteArrayInputStream(file.getBytes());
	    	
	    	InputStream fileInputStream = file.getInputStream();
	    	
	    	byte[] buffer = new byte[4096];
	    	int bytesRead = -1;
	    	
	    	while ((bytesRead = fileInputStream.read(buffer)) != -1) {
	    		dos.write(buffer, 0, bytesRead);
	    	}
	    	 // 세션에다가 담기 
			if(!file.getName().equals("")) {
				HttpSession session =  request.getSession();
				List<String> fileSessionList =  (List<String>) session.getAttribute("fileSessionList");
				if(fileSessionList == null) {
				    fileSessionList = new ArrayList<String>();
				}
				fileSessionList.add(file.getOriginalFilename());
				session.setAttribute("fileSessionList", fileSessionList);
			}
			
	    	// 첫 번째 멀티파트 파트 끝 마무리
	    	dos.write(crlf.getBytes());
	    	dos.write((twoHyphens + boundary + crlf).getBytes("UTF-8"));
	    	// 입력 스트림과 출력 스트림 닫기
	    	fileInputStream.close();
	    }
		

	    // 두 번째 멀티파트 파트 작성 (itemName)
	    dos.write((twoHyphens + boundary + crlf).getBytes("UTF-8"));
	    dos.write(("Content-Disposition: form-data; name=\"itemName\"" + crlf).getBytes("UTF-8"));
	    dos.write(crlf.getBytes("UTF-8"));
	    dos.write(itemName.getBytes("UTF-8"));
	    dos.write(crlf.getBytes("UTF-8"));
	    
	    List<MemberVo> list = new ArrayList<MemberVo>();

		for(int i =0; i<10; i++) {
			
			MemberVo member = new MemberVo();
			member.setUserid("test " + Math.random() * 100);
			member.setPassword( (int)(10522 +  Math.random() * 100) );
			member.setEmail("google" + Math.random() * 100);
			member.setPhoneNum("565451222" + Math.random() * 100);
			
			list.add(member);
		}
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.writeValueAsString(list);
		String json = mapper.writeValueAsString(list);
		
		dos.write((twoHyphens + boundary + crlf).getBytes("UTF-8"));
		dos.write(("Content-Disposition: form-data; name=\"json\"" + crlf).getBytes("UTF-8"));
		dos.write(("Content-Type: application/json" + crlf).getBytes("UTF-8"));
		dos.write(crlf.getBytes("UTF-8"));
		dos.write(json.getBytes("UTF-8"));
		dos.write(crlf.getBytes("UTF-8"));
		// 전송할 데이터의 마지막을 알리는 구분자 문자열 쓰기
		dos.write((twoHyphens + boundary + twoHyphens + crlf).getBytes("UTF-8"));    
	    dos.flush();
	    dos.close();

	    // HTTP 응답 코드 확인
	    int responseCode = conn.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        // 성공적으로 전송 완료
	    } else {
	        // 전송 실패
	    }

	    // HTTP 연결 닫기
	    conn.disconnect();

	    // 업로드 폼 페이지로 이동
	    return "upload-form2";
	}
	// 파일 전송받는곳
	@RequestMapping(value = "/FileSend", method = RequestMethod.POST)
	public String FileSend(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		List<MemberVo> list = new ArrayList<MemberVo>();
		// 멀티파트 폼 데이터 파서 생성
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
	    if (multipartResolver.isMultipart(request)) {
	        // 멀티파트 요청에서 파일과 폼 데이터 추출
	        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        List<MultipartFile> files = multipartRequest.getFiles("file");
	        
	        String itemName = multipartRequest.getParameter("itemName");
	        String jsonData = multipartRequest.getParameter("json");
	        
	        ObjectMapper objectMapper = new ObjectMapper();
	        
	        list = objectMapper.readValue(jsonData , new TypeReference<List<MemberVo>>(){});
	        
	        String path = request.getSession().getServletContext().getRealPath("resources/file");
	        File f = new File(path);
	        if (!f.exists()) {
				f.mkdirs();
			}
	        try {
	        	
	        	for(int i =0; i<files.size(); i++) {
	        		MultipartFile file =  files.get(i);
	        		String originalFileName = file.getOriginalFilename();
	        		int lastDotIndex = originalFileName.lastIndexOf('.');
	        		String hak = originalFileName.substring(lastDotIndex,originalFileName.length());
	        		
	        		String filenameWithoutExtension = lastDotIndex > 0 ? originalFileName.substring(0, lastDotIndex) : originalFileName;
	        		String fileName = originalFileName;
	        		int index = 1;
	        		while (new File(path, fileName).exists()) {
	        			fileName = filenameWithoutExtension +"" + index +""+ hak;
	        			index++;
	        		}
	        		Path filePath = Paths.get(path, fileName);
	        		File dest = filePath.toFile();
	        		file.transferTo(dest);
	        		
	        		
	        		
	        	}
	        	
			} catch (Exception e) {
			}
	        // 처리 결과에 따른 응답 반환
	        return "upload-form2";
	    } else {
	        // 멀티파트 폼 데이터가 아닌 요청 처리
	        // ...
	        return "upload-form2";
	    }
	}
	// 파일 경로의 이미지들 모두 jsp에 출력 
	@RequestMapping(value = "/fileList", method = RequestMethod.GET)
	public String fileList(HttpServletRequest request , Model model) {
		
		String path = request.getSession().getServletContext().getRealPath("/resources/file");
		File folder = new File(path);
		
		if(!folder.isDirectory()) {
			System.out.println("유효하지 않은 폴더 경로입니다.");
			return "upload-form2";
		}
		File[] files = folder.listFiles();
		List<String> fileList = new ArrayList<String>();
		
		for(File file : files ) {
			fileList.add(file.getName());
		}
		model.addAttribute("fileList" ,fileList);
		
		return "fileList";
	}
	// 파일 다운로드 
	@RequestMapping(value = "/fileDownload", method = RequestMethod.GET)
	public void fileDownload(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		String fileName = request.getParameter("fileName");
		String path = request.getSession().getServletContext().getRealPath("/resources/file");
		
		File file = new File(path + "/" + fileName);
		ServletOutputStream outputStream = response.getOutputStream();
		response.setContentType("application/octet-stream");
		
		System.out.println(file.getName());
		response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(file.getName(), "UTF-8") + "\"");

		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buffer = new byte[8192];
		int length;
		while ((length = fileInputStream.read(buffer)) != -1) {
		    outputStream.write(buffer, 0, length);
		}
		fileInputStream.close();
		outputStream.flush();
		outputStream.close();
		
	}
	// 세션이 업로드한 리스트만 보기 
	@RequestMapping(value = "/getfileList", method = RequestMethod.GET)
	public String getfileList(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		List<String> fileSessionList =  (List<String>) request.getSession().getAttribute("fileSessionList");
		if(fileSessionList != null)	{
			request.setAttribute("fileList", fileSessionList);
		}
		
		return "fileList";
	}
	
	@RequestMapping(value = "/jang", method = RequestMethod.GET)
	public String jang(HttpServletRequest request , @ModelAttribute MemberVo memberVo,Model model) {
		
		Map<String, Object> map = requestParamMethod.requestToMap(request);
		
		
		return "jang";
	}
	
}

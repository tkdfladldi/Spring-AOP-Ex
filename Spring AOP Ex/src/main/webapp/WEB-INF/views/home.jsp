<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form name="form1" action="login" method="post">
<table border="1" width="400px">
	<tr>
		 <td>아이디</td>
		 <td><input  name="userid"></td>
	</tr>
	<tr>
		 <td>비밀번호</td>
		 <td><input type="password"  name="password"></td>
	</tr>
	<tr>
		 <td colspan="2" align="center">
		 <button type="submit" id="btnLogin">로그인 </button>
		 <c:if test="${not empty member.userid}"> 
  				asdsad
  		</c:if>
		</td>
	</tr>
	
  
</table>
</form>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">

function imgClick(fileName) {
	location.href = "/ex/fileDownload?fileName="+fileName;
	
}

</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="fileList" items="${fileList}">
		<div>
			<img onclick="imgClick('${fileList}');" class="card-img-top" src="${pageContext.request.contextPath}/resources/file/${fileList}"/>
		</div>
	</c:forEach>

</body>
</html>
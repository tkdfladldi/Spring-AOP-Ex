<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">


function formSubmit() {
	const myform = document.getElementById("myForm");
	document.getElementById('myForm').submit();  
}
</script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
<title>Insert title here</title>
</head>
<body>
 <form id="myForm" action="/ex/servlet/v2/upload" method="post"  enctype="multipart/form-data">
	<ul>
		<li> 상품명 <input type="text" name="itemName"></li>
		<li> 파일 <input type="file" name="files" id="files" multiple> </li>
		<li> <a onclick="fileOnclick();">클릭</a></li>
		
		
		
	</ul>
	<input onclick="formSubmit();" type="button" value="제출">
	<a href="/ex/fileList"> 파일 업로드 된 리스트 모두 보기</a>
	<a href="/ex/getfileList"> 세션이 업로드한 리스트만 보기 </a>
  </form>
</body>
</html>
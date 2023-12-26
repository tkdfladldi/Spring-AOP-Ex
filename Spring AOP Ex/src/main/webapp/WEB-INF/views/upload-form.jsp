<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">


function fileOnclick() {
	const fileInput = document.getElementById('file');
	
	if(fileInput.files[0] != null){
		
	const fileName = fileInput.files[0].name;
	const reader = new FileReader();
	
	reader.onload = function(event) {
		
		const xhr = new XMLHttpRequest();
		const fileData = event.target.result;
	    const data = new FormData();
		data.append("fileName" , fileName);
		data.append("fileData" , fileData);
		const url = '/ex/httpConectionTest'; 
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary" + (new Date()).getTime());
		xhr.send(data);
		
	};
	reader.readAsDataURL(fileInput.files[0]);
	
	}

	
}
</script>
<meta charset="EUC-KR">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
<title>Insert title here</title>
</head>
<body>
 <form action="/ex/servlet/v1/upload" method="post"  enctype="multipart/form-data">
	<ul>
		<li> 상품명 <input type="text" name="itemName"></li>
		<li> 파일 <input type="file" name="file" id="file" > </li>
		<li> <a onclick="fileOnclick();">클릭</a></li>
		
		
		
	</ul>
	<input type="submit">
  </form>
</body>
</html>
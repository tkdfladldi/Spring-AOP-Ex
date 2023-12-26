<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function ExcelUpload() {
		
	    var formData = new FormData();
	    var inputFile = $('#file')[0].files;
	    
	    formData.append("row", $('input[name="row"]').val());
	    formData.append("cell", $('input[name="cell"]').val());
	    
	    // 파일이 선택되지 않은 경우
	    if (inputFile.length == 0) {
	        alert("파일을 선택해주세요.");
	        return;
	    }
	    
	    // 선택된 파일 추가
	    for (var i = 0; i < inputFile.length; i++) {
	    	formData.append("file", inputFile[i]);
	    }
			
			
			 $.ajax({
				  url: "/ExcelUpload",
				  type: "POST",
				  data: formData, // 요청 데이터
				  dataType: "json", // 응답 데이터 타입
				  processData: false,
			      contentType: false,
				  success: function(data, textStatus, jqXHR) {
				    // 요청이 성공했을 때 실행될 콜백 함수
				    console.log("요청 성공: " );
				  },
				  error: function(jqXHR, textStatus, errorThrown) {
				    // 요청이 실패했을 때 실행될 콜백 함수
				    console.log("요청 실패: ");
				  }
			}); 
			
	}
	
function find() {
		
	    var formData = new FormData();
	    var inputFile = $('#file')[0].files;
	    
	    formData.append("row", $('input[name="row"]').val());
	    formData.append("cell", $('input[name="cell"]').val());
	    
	    // 파일이 선택되지 않은 경우
	    if (inputFile.length == 0) {
	        alert("파일을 선택해주세요.");
	        return;
	    }
	    
	    // 선택된 파일 추가
	    for (var i = 0; i < inputFile.length; i++) {
	    	formData.append("file", inputFile[i]);
	    }
			
			
			 $.ajax({
				  url: "/find",
				  type: "POST",
				  data: formData, // 요청 데이터
				  dataType: "json", // 응답 데이터 타입
				  processData: false,
			      contentType: false,
				  success: function(data, textStatus, jqXHR) {
				    // 요청이 성공했을 때 실행될 콜백 함수
				    console.log("요청 성공: " );
				  },
				  error: function(jqXHR, textStatus, errorThrown) {
				    // 요청이 실패했을 때 실행될 콜백 함수
				    console.log("요청 실패: ");
				  }
			}); 
			
}


/* function check(str) {
	var Element = document.getElementById(str.id);
	var variable = { girl: "girl", men: "men" };
	
	if(Element.checked){
		if(Element.id === variable.girl ){
			document.getElementById(variable.men).checked = false;
		}else{
			document.getElementById(variable.girl).checked = false;
		}
	}
} */

//체크박스 그룹을 선택하여 이벤트 리스너를 등록
var checkboxes = document.querySelectorAll('.custom-checkbox');
checkboxes.forEach(function(checkbox) {
  checkbox.addEventListener('change', function() {
    check(this);
  });
});

function check(clickedCheckbox) {
  // 체크박스 그룹을 선택하여 체크된 체크박스를 찾음
  var checkedCheckboxes = document.querySelectorAll('.custom-checkbox:checked');

  if (checkedCheckboxes.length === 2) {
    var targetCheckboxId;

    if (clickedCheckbox.id === 'girl') {
      targetCheckboxId = 'men';
    } else {
      targetCheckboxId = 'girl';
    }

    // 목표 체크박스를 선택 해제
    document.getElementById(targetCheckboxId).checked = false;
  }
}


</script>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form name="form1" action="login" method="post">
<table border="1" width="400px">
	<tr>
		 <td colspan="2" align="center">
		 <a type="button" href="/ex/login" id="btnLogin">로그인 </a>
		 <button type="button" id="btnLogin">회원가입</button>
		  <a type="button" href="/ex/logOut" id="btnLogin">로그아웃 </a>
		  <a type="button" href="/ex/session-info">세션 정보</a>
		</td>
	</tr>
</table>
		<ul>
		
			<li><a href="/ex/servlet/v1/upload">서블릿 파일 업로드1 </a></li>
			<li><a href="/ex/servlet/v2/upload">서블릿 파일 업로드2 </a></li>
			<li><a href="/ex/httpConection">HttpConnection</a></li>
			
			<li><a href="/ex/httpConectionTest">HttpConnection 시험 테스트</a></li>
		</ul>
		<input name="row" type="text" >
		<input name="cell"  type="text" >
		
		     파일 <input type="file" name="file" id="file" multiple> 
		  <button  onclick="ExcelUpload();"  type="button"  style="background-color: green; color: white; padding: 10px 20px; border: none; border-radius: 5px;" >엑셀 업로드</button>
		  
		  <button  onclick="find();"  type="button"  style="background-color: green; color: white; padding: 10px 20px; border: none; border-radius: 5px;" >3000개 찾기</button>
</form>
<P>  The time on the server is ${serverTime}. </P>


<input type="checkbox" id="girl"  class="custom-checkbox" onclick="check(this);">
<input type="checkbox"  id="men"  class="custom-checkbox" onclick="check(this);">

</body>
</html>

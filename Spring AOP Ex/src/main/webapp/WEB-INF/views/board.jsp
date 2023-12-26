<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<head>
  <meta charset="UTF-8">
  <title>게시판</title>
  <style>
    /* CSS 스타일링 */
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      margin: 0;
    }
    
    .container {
      width: 80%;
      margin: 0 auto;
    }
    
    .header {
      background-color: #333;
      color: #fff;
      padding: 20px;
      text-align: center;
    }
    
    .post {
      background-color: #fff;
      border: 1px solid #ddd;
      padding: 20px;
      margin: 20px 0;
    }
    
    .title {
      font-size: 20px;
      font-weight: bold;
      margin-bottom: 10px;
    }
    
    .date {
      font-size: 14px;
      color: #666;
      margin-bottom: 20px;
    }
    
    .content {
      font-size: 16px;
      line-height: 1.5;
    }
    
    .pagination {
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 30px;
    }
    
    .page-item {
      margin: 0 10px;
    }
    
    .page-link {
      display: inline-block;
      background-color: #fff;
      border: 1px solid #ddd;
      color: #333;
      padding: 10px;
      text-decoration: none;
      transition: background-color 0.3s;
    }
    
    .page-link:hover {
      background-color: #ddd;
    }
    
    .active {
      background-color: #333;
      color: #fff;
    }
    
    /* 이미지 스타일링 */
    .image-container {
      display: flex;
      justify-content: center;
      margin-top: 30px;
    }
    
    .image {
      width: 100%;
      max-width: 500px;
    }
  </style>
  
  
  <script type="text/javascript">
  
  
  
  function next(rang) {
	  
	rang = rang +1
	page = (rang-1) * 10 +1;
	
	location.href = "/board?rang="+ rang + "&page=" + page;  
  }
  
  function prev(rang) {
	  
	rang = rang -1
	page = rang * 10;
	
	location.href = "/board?rang="+ rang + "&page=" + page;  
	  
  }
  
  
  function pageCilck(rang , page) {
	
	location.href = "/board?rang="+ rang + "&page=" + page;  
  }

  function showPost(content) {
	  // 팝업 창 생성
	  const popup = window.open("boardContent", "postPopup", "width=600, height=800");
	
	  popup.onload = function(){
		  popup.document.getElementById("content").innerHTML = content;
	  }
  }
  
  function removeItem() {
	  
	  var arr = [];
	  var divElement = document.getElementsByClassName("post");
	  for(var i = 0; i< divElement.length; i++){
		  var box = divElement[i].children.namedItem("chckBox").checked;
		  if(box){
			  arr.push(divElement[i]);
		  }
	  }
	  
	  for(var i=0; i<arr.length; i++ ){
		  arr[i].remove();
	  }
	}
  
	function addItem() {
		
		var inputDate = document.getElementById("itemInput").value;
		var divElement = document.getElementsByClassName("ex");
	    var newDivElement = document.createElement("div");
		newDivElement.className = "post";
		    newDivElement.innerHTML = 
		        "<input type='checkbox' name='chckBox'>"+
		        "<img style='width: 200px; float: left; overflow: hidden;  margin-right: 20px; ' class='image' src='https://news.nateimg.co.kr/orgImg/ch/2023/04/24/7C6KOOI5T5BPNKRPM5PMVDP24E.jpg' alt='이미지'>"+
		        "<h2 class='title' onclick='showPost();' style='cursor: pointer;'>"+inputDate+"</h2>"+
		        "<p class='date'>작성일: </p>" +
		        "<p class='content'></p>"
		    ;

		divElement[0].appendChild(newDivElement);
	
	}
  
  function change() {
	  var arr = [];
	  var divElement = document.getElementsByClassName("post");
	  for(var i = 0; i< divElement.length; i++){
		  var box = divElement[i].children.namedItem("chckBox").checked;
		  if(box){
			  arr.push(divElement[i]);
		  }
	  }
	  
		  var temp = arr[0].outerHTML;
		  arr[0].outerHTML = arr[1].outerHTML;
		  arr[1].outerHTML = temp;
	  
	
  }
  </script>
  
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
  <div class="container">
    <div class="header">
      <h1>게시판</h1>
      <input type="text" id="itemInput" placeholder="Enter an item">
	<button type="button" onclick="addItem()">Add Item</button>
	<button type="button"  onclick="removeItem()">Remove Item</button>
	<button type="button"  onclick="change()">체인지</button>
    </div>
    <div class="ex">
    <!-- 게시물 목록 시작 -->
    <c:forEach items="${Board}" var="Board">
	    <div class="post">
	    <!-- 이미지 추가 -->
	      <input type="checkbox" name="chckBox">
	      <img style="width: 200px; float: left; overflow: hidden;  margin-right: 20px; " class="image" src="https://news.nateimg.co.kr/orgImg/ch/2023/04/24/7C6KOOI5T5BPNKRPM5PMVDP24E.jpg" alt="이미지">
	      <h2 class="title" onclick="showPost('${Board.content}');" style="cursor: pointer;" >${Board.title}</h2>
	      <p class="date">작성일: ${Board.date}</p>
	      <p class="content">${Board.content}</p>
	    </div>
	</c:forEach>    
	</div>
	    
    <!-- 게시물 목록 끝 -->
    
    <!-- 페이징 시작 -->
    <div class="pagination">
    
      <div class="page-item">
      	<c:if test="${Page.rang >  1}">
     	   <a onclick="prev(${Page.rang});" id="prev" class="page-link" href="#">이전</a>
        </c:if>
      </div>
      
      <c:forEach var="i" begin="${Page.startPage}" end="${Page.lastPage}">
        <div class="page-item">
        <a  class="page-link" onclick="pageCilck(${Page.rang}, ${i});">${i}</a>
      	</div>
      </c:forEach>
      <div class="page-item">
      	<c:if test="${Page.nextBool}">
     	   <a onclick="next(${Page.rang});" id="prev" class="page-link" href="#">다음</a>
     	</c:if>
      </div>
    </div>
  </div>
</body>
</html>
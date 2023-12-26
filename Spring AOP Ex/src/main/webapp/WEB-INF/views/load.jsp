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
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  
  <script src="resources/grid.js"></script>
  
  <script type="text/javascript">
  
  window.onload = function name() {
	  $.ajax({
		    url: '/load',
		    type: 'post',
		    success: function(response) {
				
		    	
		    	gridSet("grid" , response);
				
				
		    },
		    error: function(xhr, status, error) {
		    }
	   });
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
    <table class="board-list" id="grid">
		<thead>
			<tr>
				<th id="userid">아이디</th>
				<th id="password">패스워드</th>
				<th id="email">이메일</th>
				<th id="phoneNum">폰넘버</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	</div>
	    
    
  </div>
</body>
</html>
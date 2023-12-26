<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>장지아 프로그램</title>
	<style>
		table {
		  border-collapse: collapse;
		  width: 100%;
		  margin: 0 auto;
		  border-spacing: 0;
		}
		
		.container {
		  max-width: 1200px;
		  margin: 0 auto;
		  padding: 20px;
		}
				
		td {
		  border: 1px solid #ddd;
		  padding: 10px;
		  text-align: center;
		}
		
		th {
		  background-color: #555;
		  color: #fff;
		  padding: 10px;
		  text-align: center;
		}
		
		input[type="text"] {
		  width: 100%;
		  box-sizing: border-box;
		  border: none;
		  font-size: 16px;
		}
		
		/* 수정: 버튼 디자인 */
		.button {
		  display: inline-block;
		  border-radius: 4px;
		  background-color: #4CAF50;
		  border: none;
		  color: #fff;
		  text-align: center;
		  font-size: 16px;
		  padding: 10px;
		  width: 100px;
		  transition: all 0.5s;
		  cursor: pointer;
		  margin: 5px;
		}

		.button:hover {
		  background-color: #3e8e41;
		}

		.blue {
		  background-color: #2196F3;
		}

		.red {
		  background-color: #f44336;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		
		var trCount = 0;
		
		// 행 버튼 추가 
		function buttonAdd() {
			tbodyInputElement();
		}
		
		
		
		
		function tbodyInputElement() {
			
			 trCount++;
			 
			 var tbody = document.getElementById('tbody'); // tbody 가져오기
			 var newRow = tbody.insertRow(); // 새로운 행 추가
			 var newCell1 = newRow.insertCell(); // 새로운 셀 추가
			 var newCell2 = newRow.insertCell(); // 새로운 셀 추가
			 var newCell3 = newRow.insertCell(); // 새로운 셀 추가
			 var newCell4 = newRow.insertCell(); // 새로운 셀 추가
			 var newCell5 = newRow.insertCell(); // 새로운 셀 추가
			 var newCell6 = newRow.insertCell(); // 새로운 셀 추가
			 var newCell7 = newRow.insertCell(); // 새로운 셀 추가
			 var newCell8 = newRow.insertCell(); // 새로운 셀 추가
			 var newCell9 = newRow.insertCell(); // 새로운 셀 추가
			 
			 newCell1.innerHTML = '<input type="checkbox" style="width: 100%;">'; // 새로운 셀에 input 추가
			 newCell2.innerHTML = '<input type="text" style="width: 100%;">'; // 새로운 셀에 input 추가
			 newCell3.innerHTML = '<input type="text" style="width: 100%;">'; // 새로운 셀에 input 추가
			 newCell4.innerHTML = '<input type="text" style="width: 100%;">'; // 새로운 셀에 input 추가
			 newCell5.innerHTML = '<input type="text" style="width: 100%;">'; // 새로운 셀에 input 추가
			 newCell6.innerHTML = '<input type="text" style="width: 100%;">'; // 새로운 셀에 input 추가
			 newCell7.innerHTML = '<input type="text" style="width: 100%;">'; // 새로운 셀에 input 추가
			 newCell8.innerHTML = '<input type="text" style="width: 100%;">'; // 새로운 셀에 input 추가
			 newCell9.innerHTML = '<input type="text" style="width: 100%;">'; // 새로운 셀에 input 추가
			 
			 newCell1.className += "tr" + trCount;
			 newCell2.className += "tr" + trCount;
			 newCell3.className += "tr" + trCount;
			 newCell4.className += "tr" + trCount;
			 newCell5.className += "tr" + trCount;
			 newCell6.className += "tr" + trCount;
			 newCell7.className += "tr" + trCount;
			 newCell8.className += "tr" + trCount;
			 newCell9.className += "tr" + trCount;
		}
		
	
		
		function submit() {
			
			var myArray = [];
			
			myArray.push('apple');
			myArray.push('banana');
			myArray.push('orange');
			
			 $.ajax({
				  url: "/jang",
				  type: "GET",
				  data: {"park" : myArray ,"park2" : "hello world"}, // 요청 데이터
				  dataType: "json", // 응답 데이터 타입
				  success: function(data, textStatus, jqXHR) {
				    // 요청이 성공했을 때 실행될 콜백 함수
				    console.log("요청 성공: " );
				  },
				  error: function(jqXHR, textStatus, errorThrown) {
				    // 요청이 실패했을 때 실행될 콜백 함수
				    console.log("요청 실패: ");
				  }
			}); 
			
			alert("준비중입니다.");
			
		}
		
		function ExcelUpload() {
			
			    var formData = new FormData();
			    var inputFile = $('#file')[0].files;
			    
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
	
	</script>
	
</head>
<body>
	<div class="container">
		<div style="text-align: center;">
		  <button type="button"  style="background-color: blue; color: white; padding: 10px 20px; border: none; border-radius: 5px;"  onclick="buttonAdd();">행 추가</button>
		  <button type="button"  style="background-color: red; color: white; padding: 10px 20px; border: none; border-radius: 5px;">행 삭제</button>
		  &nbsp;&nbsp;&nbsp;
		  <button  onclick="submit();"  type="button"  style="background-color: green; color: white; padding: 10px 20px; border: none; border-radius: 5px;" >확인</button>
		</div>
		<table>
		  <thead>
		    <tr>
		   	  <th style="width: 2%;">✔</th>
			  <th style="width: 20%;">제품명</th>
		      <th style="width: 11%;">수량</th>
		      <th style="width: 11%;">박스 단위 수량</th>
		      <th style="width: 11%;">제품 무게</th>
		      <th style="width: 11%;">박스 무게</th>
		      <th style="width: 11%;">박스 가로</th>
		      <th style="width: 11%;">박스 세로</th>
		      <th style="width: 11%;">박스 높이</th>
		    </tr>
		  </thead>
		  <tbody id="tbody">
		    <tr class="tr">
		       <td><input type="checkbox" style="width: 100%;"></td>
		       <td><input type="text" style="width: 100%;"></td>
		       <td><input type="text" style="width: 100%;"></td>
		       <td><input type="text" style="width: 100%;"></td>
		       <td><input type="text" style="width: 100%;"></td>
		       <td><input type="text" style="width: 100%;"></td>
		       <td><input type="text" style="width: 100%;"></td>
		       <td><input type="text" style="width: 100%;"></td>
		       <td><input type="text" style="width: 100%;"></td>
		    </tr>
		    <!-- 추가적인 행 추가 가능 -->
		  </tbody>
		</table>
	</div>
</body>
</html>
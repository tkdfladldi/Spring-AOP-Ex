<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>테이블과 버튼</title>
	<style>
		.container {
			display: flex;
			flex-direction: row;
			align-items: flex-start;
			justify-content: center;
		}
		table {
			border: 1px solid black;
			margin: 10px;
		}
		td {
			border: 1px solid black;
			padding: 5px;
		}
		button {
			margin: 10px;
		}
	</style>
	
	
	<script type="text/javascript">
	
	function left() {
		
		move('rightCheck' , 'leftCheck', 'lefttable');
	}
	
	function right() {
		
		move('leftCheck' , 'rightCheck','righttable');
	
	}
	
	function move(str , str3 ,str2) {
		
		let leftCheck = document.getElementsByClassName(str);
		const le = leftCheck.length;
		var arr = [];
		
		for(var i = 0; i < le; i++){
			if(leftCheck[i].checked){
				arr.push(leftCheck[i].parentNode.parentNode);
			}
		}
		
		if(arr.length > 0){
			var righttable = document.getElementById(str2);
			
			for(var i =0; i< arr.length; i++){
				arr[i].children[0].childNodes[0].className = str3;
				righttable.append(arr[i]);
			}
		}
	}
	
	</script>
</head>
<body>
	<div class="container">
		<table id="lefttable">
			<tr>
				<td><input type="checkbox" class="leftCheck"> </td>
				<td>왼쪽 테이블 내용</td>
			</tr>
			<tr>
				<td><input type="checkbox" class="leftCheck"> </td>
				<td>왼쪽 테이블 내용 222 </td>
			</tr>
			<tr>
				<td><input type="checkbox" class="leftCheck"> </td>
				<td>왼쪽 테이블 내용 333 </td>
			</tr>
		</table>
			<div class="container">
				<button type="button" onclick="left();">&lt;</button>
				<br>
				<button type="button" onclick="right();">&gt;</button>
			</div>
		<table id="righttable">
			<tr>
				<td><input type="checkbox" class="rightCheck"> </td>
				<td>오른쪽 테이블 내용</td>
			</tr>
			<tr>
				<td><input type="checkbox" class="rightCheck"> </td>
				<td>오른쪽 테이블 내용 222 </td>
			</tr>
			<tr>
				<td><input type="checkbox" class="rightCheck"> </td>
				<td>오른쪽 테이블 내용 333 </td>
			</tr>
		</table>
	</div>
</body>
</html>
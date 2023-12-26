<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title style="color:black;">게시물 상세보기</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-Ft1KreJft+Nw2n/r3IbYn50J7KjI8NPh9NtZxB+n33LnNzFGGkMwI0e/3Y/i0aHKJjKzjcZm9XlCzOQ2e5ivg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <style>
    body {
      background-color: #f7f7f7;
      font-family: Arial, Helvetica, sans-serif;
    }
    .container {
      margin: auto;
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0px 0px 10px #ccc;
    }
    h2 {
      margin-top: 0;
      color: black;
    }
    #content {
      line-height: 1.5;
      font-size: 18px;
      margin-bottom: 20px;
    }
    .fa {
      margin-right: 5px;
    }
    a {
      text-decoration: none;
    }
    .btn {
      border-radius: 3px;
      font-size: 16px;
      font-weight: bold;
      padding: 10px 20px;
      cursor: pointer;
    }
    .btn-primary {
      background-color: #007bff;
      color: #fff;
      border-color: #007bff;
    }
    .btn-primary:hover {
      background-color: #0069d9;
      border-color: #0062cc;
    }
  </style>
</head>
<body>
  <div class="container" style="width:600px; height:800px;">
    <h2><i class="fas fa-file-alt"></i> 게시물 내용</h2>
    <p id="content"></p>
    <a href="#" class="btn btn-primary"><i class="fas fa-chevron-left"></i> 목록으로 돌아가기</a>
  </div>
</body>
</html>
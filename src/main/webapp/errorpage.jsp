<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="er" scope="request" class="bean.API_bean.UserAddress" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/style.css">
<title>エラーページ</title>
</head>
<body>
	<h1>エラー</h1>
	<h2>入力情報</h2>
	<p><%=er.getAddress()%></p>
	<form action="/DisasterRelief/userForm.html" method="post">
    <button type="submit">戻る</button>
</form>
</body>
</html>
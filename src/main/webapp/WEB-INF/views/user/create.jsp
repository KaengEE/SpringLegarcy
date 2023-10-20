<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 만들기</title>
</head>
<body>
	<h1>사용자 생성하기</h1>
	<form method="POST">
		<p>이름 : <input type="text" name="name" /></p>
		<p>이메일 : <input type="email" name="email" /></p>
		<p>패스워드 : <input type="password" name="password" /></p>
		<p>연봉 : <input type="text" name="salary" /></p>
		<p><input type="submit" value="저장" />
	</form>
</body>
</html>
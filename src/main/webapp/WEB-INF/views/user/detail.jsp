<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 상세</title>
</head>
<body>
  <h1>유저 상세</h1>
  <p>이름 : ${ data.name } </p>
  <p>이메일 : ${ data.email }</p>
  <p>비밀번호 : ${ data.password }</p>
  <p>연봉 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.salary}" /> 만원</p> 
  <p>입력일 : <fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss" /></p>

  <p>
   <a href="/user/update?userId=${userId}">수정</a>
  </p>
  <form method="POST" action="/user/delete">
   <input type="hidden" name="userId" value="${userId}" />
   <input type="submit" value="삭제" />
  </form>
  <p>
   <a href="/user/list">목록으로</a>
  </p>
</body>
</html>

<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>  
<head>  
	<title>사용자 목록</title>  
</head>  
<body>  
<h1>사용자 목록</h1>
<div>
	<form>
		<input type= "text" placeholder="검색" name="keyword" value="${keyword}"/>
		<input type= "submit" value="검색"/>
	</form>
</div>
<table>  
	<thead>  
		<tr>  
			<td>이름</td>  
			<td>이메일</td>  
			<td>비밀번호</td>  
			<td>연봉</td>  
		</tr>  
	</thead>  
	<tbody>  
	
	<c:forEach var="row" items="${data}">  <!-- data는 list -->
		<tr>  
			<td>  
				<a href="/user/detail?userId=${row.user_id}">  
				${row.name}  
				</a>  
			</td>
			<td>${row.email}</td> 
			<td>${row.password}</td>  
			<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.salary}" />만원</td>  
		</tr>  
	</c:forEach>  
	
	</tbody>  
</table>  
<p>  
<a href="/user/create">생성</a>  
</p>  
</body>  
</html>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>멤버목록</title>
</head>
<body>
<h1>
	멤버목록
</h1>

	<table>
	<thead>
		<th> 아이디 </th>
		<th> 이름 </th>
		<th> 패스워드 </th>
		<th> 이메일 </th>
		<th> 삭제하기 </th>
		<th> 수정하기 </th>
	</thead>
	
	<form action="/spring/member" method="post">
	<c:forEach items="${list }" var="list">
		<tr>
			<td>${list.user_id }	</td>
			<td>${list.user_name }	</td>
			<td>${list.pw }	</td>
			<td>${list.email }	</td>
			<td><input type="submit" value="수정" id="btn1" onclick="update()"/></td>
		</tr>		
	</c:forEach>
	</table>
	</form>
	
</body>
</html>

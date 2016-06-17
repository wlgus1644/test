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
	
	</thead>
	
	
	<c:forEach items="${list }" var="list">
		<tr>
			<td>${list.user_id }	</td>
			<td>${list.user_name }	</td>
			<td>${list.pw }	</td>
			<td>${list.email }	</td>
			<td>
				<form action="/spring/memberDelete" method="post">
				<input type="hidden" id="user_id" name="user_id" value="${list.getUser_id() }">
				<input type="submit" value="삭제" id=${user_id} name=${user.id } /></td>
		</tr>		
	</c:forEach>
	</table>
	</form>
	
</body>
</html>

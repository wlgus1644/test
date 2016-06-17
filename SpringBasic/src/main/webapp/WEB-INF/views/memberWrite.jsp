<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>멤버등록</title>
</head>
<body>
<h1>
	멤버등록
</h1>

	<form action="/spring/member" method="post">
	<table>
	<tr>
		<th> 아이디 </th>
		<td> <input type="text" name="user_id"/> </td>
	</tr>
	<tr>
		<th> 이름 </th>
		<td> <input type="text" name="user_name"/> </td>
	</tr>
	<tr>
		<th> 패스워드 </th>
		<td> <input type="text" name="pw"/> </td>
	</tr>
	<tr>
		<th> 이메일 </th>
		<td> <input type="text" name="email"/> </td>
	</tr>
	</table>
	<input type="submit" value="등록"/>
	</form>
</body>
</html>

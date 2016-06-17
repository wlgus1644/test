<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>

<%@include file="./include/header.jsp" %>

<div class="container">

<h1>게시판</h1>
	
	<table class="table table-condensed">
	<thead>
	<tr>
		<th> No. </th>
		<th> 제목 </th>
		<th> 내용 </th>
		<th> 사용자 </th>
		<th> 날짜 </th>
		<th> 조회수 </th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${list }" var="list">
		<tr>
			<td>${list.board_no }	</td>
			<td><a href="/rest/${list.board_no}"> ${list.title } (${list.reply_cnt })	</a></td>
			<td>${list.content }	</td>
			<td>${list.user_name }	</td>
			<td>${list.regdate }	</td>
			<td>${list.view_cnt }	</td>
		</tr>		
	</c:forEach>
	</tbody>
	</table>
	
</div>
<%@include file="./include/footer.jsp" %>


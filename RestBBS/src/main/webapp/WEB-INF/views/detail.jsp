<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>

<%@include file="./include/header.jsp" %>

<h1>
	제목 : ${vo.title }
</h1>

	<table class="table">
		<tr>
			<th>글제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>${vo.user_name }</td>
		</tr>
			<tr>
			<th>내용</th>
			<td><c:out value="${vo.content }" escapeXml="false"/></td>
			
		</tr>	
</table>

<form action="/rest/${vo.board_no }" method="post">
	<input type="hidden" id="_method" name="_method" value="delete"/>
	<input type="submit" class="btn btn-primary" value="삭제"/>
</form>

<h3>덧글</h3>

<div id="reply_list"></div>
<div id="reply_page"></div>


<form id="reply">
<input type="text" id="content" name="content" size="50"/>
작성자:<input type="text" id="user_name" name="user_name" size="10"/> 
<input type="button" class="btn btn-primary" value="등록" onclick="insertReply()"/>
</form>

<script>

	var bno = '${vo.board_no}';
	var currentPage = 1;
	
	
	function deleteReply(rno){ 
		alert(rno);
		$.ajax({
			type:'delete',
			url: '/reply/'+rno,
			headers: {"Content-Type" : "application/json",
					  "X-HTTP-Method-Override" : "DELETE"},
			dataType:'text',
			data : '',
			success : function(result){
				if(result=="SUCCESS")
				getReplyList();
				
			} 
			
		});
		
	}
	
	

	function insertReply(){ 
		
		var reply_content=$("#content").val();
		var reply_user=$("#user_name").val();
		
		$.ajax({
			type:'post',
			url: '/reply/'+bno,
			headers: {
				"Content-Type" : "application/json",
			},
			dataType:'text',
			data : JSON.stringify({content:reply_content, user_name:reply_user}),
			success : function(result){
				if(result=="SUCCESS")
				alert(result);
				getReplyList(currentPage);
			} 
			
		});
		
	}


	function setReplyList(list){
		
		var result = "<ul>";
		
		$(list).each(function() {
			result += "<li>"
				   +this.content 
				   +this.user_name
				   +this.regdate +"</li>";
				   +"<input type='button' id='btn_del' name='btn_del' value='삭제' onclick='deleteReply("+list.reply_no+")' class='btn btn-danger'/>"
				   +"</li>";
		});
		
		
		
//			for(key in list){
//				result += "<li>" 
//							+list[key].user_name +"&nbsp;&nbsp;"
//							+list[key].content+ "&nbsp;&nbsp;"
//							+list[key].regdate
//							+"<input type='button' id='btn_del' name='btn_del' value='삭제' onclick='deleteReply("+list[key].reply_no+")' class='btn btn-danger'/>"
//							+"</li>";
//							}
				result += "</ul>"
		document.getElementById("reply_list").innerHTML = result;
	}
	
	function getReplyList(page){
			
		$.ajax({
			type:'get',
			url: '/reply/'+bno+'/'+page,
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET",
			},
			dataType:'json',
			data : '',
			success : function(result){
		
				setReplyList(result.l);
				setPagePrint(result.p);		
			} 
			
		});	
		currentPage = page;
	}
	
	
	function setPagePrint(pm){
		var str="<ul class='pagination'>";
		if(pm.prev)
			str	+=	"<li> <a onclick='getReplyList("+(pm.startPage-1)+")'> &lt; </li>"
		
		for(var i = pm.startPage; i<= pm.endPage; i++){
			if(i == pm.criteria.page){
				str += "<li class='active'><a href='#'>" + i + "</a></li>";
			}else{
				str += "<li><a onclick='getReplyList("+i+")' style='cursor:hand'>" + i + "</a></li>";
			}
			
		}
			
		if(pm.next)
			str	+= "<li> <a onclick='getReplyList("+(pm.endPage+1)+")'> &gt; </li>"
			
		str += "</ul>"	
		document.getElementById("reply_page").innerHTML = str;
	}
	
	getReplyList(1);
	
</script>
	
<%@include file="./include/footer.jsp" %>
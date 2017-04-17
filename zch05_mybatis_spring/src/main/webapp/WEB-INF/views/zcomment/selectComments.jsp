<%@page import="java.io.*,javax.servlet.*,java.util.*,yes.joywins.service.*,yes.joywins.domain.*,org.springframework.context.*,org.springframework.context.support.*" 
		contentType="text/html; charset=utf8"
		pageEncoding="UTF-8"%>
		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
  <head>
    <title>comment_selects</title>
  </head>    
  <body>
  	<h1>comment_selects</h1>
	
	<table class="table table-bordered">
		<tr>
			<th>댓글번호</th>
			<th>작성자 아이디</th>
			<th>작성일시</th>
			<th style="width: 40px">댓글내용</th>
		</tr>
	
	
		<c:forEach items="${commentVO}" var="comment">
		
			<tr>
				<td>${comment.comment_no}</td>
				<td>${comment.user_id}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${comment.reg_date}" /></td>
				<td>${comment.comment_content}</td>
			</tr>
		
		</c:forEach>	
	</table>	

			  
  </body>
</html>



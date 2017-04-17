<%@page import="java.io.*,javax.servlet.*,java.util.*,yes.joywins.service.*,yes.joywins.domain.*,org.springframework.context.*,org.springframework.context.support.*" 
		contentType="text/html; charset=utf8"
		pageEncoding="UTF-8"%>
		
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
  <head>
    <title>comment_select</title>
  </head>    
  <body>
  	<h1>comment_select / @ModelAttribute</h1>
	
	<table class="table table-bordered">
		<tr>
			<th>댓글번호</th>
			<th>작성자 아이디</th>
			<th>작성일시</th>
			<th style="width: 40px">댓글내용</th>
		</tr>
		
		<tr>
			<td>${commentVO.comment_no}</td>
			<td>${commentVO.user_id}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${commentVO.reg_date}" /></td>
			<td>${commentVO.comment_content}</td>
		</tr>
		
	</table>	

			  
  </body>
</html>



<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
		ServletContext context=getServletContext();
		String dbUser = context.getInitParameter("dbUser");
		String dbPass = context.getInitParameter("dbPass");
	%>

<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>

<script type="text/javascript" src="<%= request.getContextPath() %>/javascript/list.js"></script>
</head>
<body>
	<form method="POST" action="<%= request.getContextPath() %>/guestbook/write">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br/>
	<!-- JSTL Loop -->
	<c:forEach items="${list }" var="vo">
		<table width=510 border=1>
			<tr>
				<td>[${vo.no }]</td>
				<td>[${vo.name }]</td>
				<td>[${vo.regDate }]</td>
				<td><a href="<%= request.getContextPath() %>/guestbook/delete/${vo.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4>[${vo.content }]</td>
			</tr>
		</table>
	        <br/>
    </c:forEach>
    
    	<br/>
	<table width=510 border=1>
		<tr>
			<td>[1]</td>
			<td>홍길동</td>
			<td>2018-01-15</td>
			<td><a href="<%= request.getContextPath() %>/deleteform.jsp">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4>안녕하세요<br/>첫번째글입니다.</td>
		</tr>
	</table>
        <br/>
	<table width=510 border=1>
		<tr>
			<td>[1]</td>
			<td>장실산</td>
			<td>2018-01-15</td>
			<td><a href="<%= request.getContextPath() %>/deleteform.jsp">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4>안녕하세요<br/>두번째글입니다.</td>
		</tr>
	</table>
        <br/>
    
</body>
</html>
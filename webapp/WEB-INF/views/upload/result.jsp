<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- urlImage ->img 태그에 표시 -->
<img src="${pageContext.servletContext.contextPath }/${urlImage }">
<a href="${pageContext.servletContext.contextPath }/upload/form">
다시 업로드
</a>	
</body>
</html>
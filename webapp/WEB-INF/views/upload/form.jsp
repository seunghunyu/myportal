<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${pageContext.servletContext.contextPath }/upload/upload"
		  enctype="multipart/form-data">
		  <label>File</label>
		  <input type="file" name="user_file">
		  <input type="submit" value="업로드">
	</form>
</body>
</html>	
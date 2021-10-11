<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->
<link type="text/css" 
	rel="stylesheet" 
	href="<%= request.getContextPath() %>/css/users.css"/>
</head>
<body>
  <div id="container">
    <!-- /header -->
    <jsp:include page="/WEB-INF/views/includes/header.jsp" />
    
    <!-- 네비게이션 영역 -->
    <jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
    
    
	<div id="wrapper">
      <div id="content">
			<!-- Content 영역 -->
      <div id="user">
      		<!-- Login form -->
      		<form id="Login-form" name="loginForm"	method="POST" action="<%= request.getContextPath() %>/users/login">
      			
      			<label class="block-label" for="email">이메일</label>
      			<input type="text" name="email">
      			<label class="block-label" for="password">비밀번호</label>
      			<input type="password" name="password">
      			
      			<input type="submit" value="로그인">
      			
      			
      		</form>
      </div>
      </div>
	</div>
	<!-- 푸터영역 -->
	<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
  </div>
</body>
</html>
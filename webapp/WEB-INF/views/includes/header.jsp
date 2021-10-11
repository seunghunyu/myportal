<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>

<div id="header">
	<h1>My Homepage</h1>
	<ul>
		<c:choose>
		<c:when test="${empty authUser }">
			<li><a href="<%= request.getContextPath() %>/users/login">로그인</a></li>
			<li><a href="<%= request.getContextPath() %>/users/join">회원가입</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<%= request.getContextPath() %>/users/logout">로그아웃</a></li>
			<li>${authUser.name }님 안녕하세요</li>
		</c:otherwise>
		</c:choose>
	</ul>
</div>

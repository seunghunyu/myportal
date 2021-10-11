<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<!-- TODO: 현재 페이지에 적절한 CSS를 임포트하십시오. -->
<link type="text/css" rel="stylesheet"
   href="<%= request.getContextPath() %>/css/users.css" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/javascript/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
   function checkEmail(btn){
      // 이메일 필드 체크
      if (btn.form.email.value.trim().length ==0 ){
         alert("이메일을 입력하시오");
         return;
      }
      
      $.ajax({
         url: "${pageContext.servletContext.contextPath}/users/emailcheck",
         type: "get",
         dataType: "json",
         data: {
            email: btn.form.email.value
         },
         success: function(response){
            if(response.data=="exists"){
               alert("이미 가입된 이메일");
            }else{
               alert("가능한 이메일");
            }
         },
         error: function(xhr,status, error){
            alert(status);
            alert(error);
         }
      })
   }
</script>
</head>
<body>
   <div id="container">
      <!-- header -->
      <jsp:include page="/WEB-INF/views/includes/header.jsp"/>
      <!-- navigation -->
      <jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
      <div id="wrapper">
         <div id="content">
            <!-- Content 영역 -->
            <div id="user">
               <!--  form id="join-form" name="joinform" method="POST"
                  action="<%= request.getContextPath() %>/users/join"-->
                  <form:form modelAttribute="userVo" id="join-form" name="joinForm" method="POST"
                           action="${pageContext.servletContext.contextPath }/users/join">
                  <!-- 입력 폼 -->
                  <label class="block-label" for="name">이름</label>
                  <!-- input type="text" name="name" id="name"-->
                  <form:input path="name"/>
                  <spring:hasBindErrors name="userVo">
                     <c:if test="${errors.hasFieldErrors('name') }">
                        <strong>${errors.getFieldErrors('name')[0].defaultMessage }</strong>
                     </c:if>
                  </spring:hasBindErrors>
                   
                  <label class="block-label" for="password">비밀번호</label>
                  <input type="password" name="password">
                   
                  <label class="block-label" for="email">이메일</label>
                  <!-- input type="text" name="email"-->
                  <form:input path="email"/>
                  <input type="button" value="중복 체크" onclick="checkEmail(this)">
                  <spring:hasBindErrors name="userVo">
                     <c:if test="${errors.hasFieldErrors('email') }">
                        <spring:message code="${errors.getFieldError('email').codes[0] }"
                                    text="${errors.getFieldError('email').defaultMessage }"/>
                     </c:if>
                  </spring:hasBindErrors>
                  
                  <input type="hidden" name="a" value="join">

                  <fieldset>
                     <legend>성별</legend>
                     <input type="radio" name="gender" value="F">여성
                     <input type="radio" name="gender" value="M">남성
                  </fieldset>

                  <input type="submit" value="가입하기">
               </form:form>
            </div>
         </div>
      </div>
      <!-- footer -->
      <jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
   </div>
</body>
</html>
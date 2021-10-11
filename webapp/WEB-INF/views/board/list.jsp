<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>My Homepage</title>
   <meta http-equiv="content-type" content="text/html; charset=utf-8">
   <link href="/myportal/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
   <div id="container">

      <div id="header">
         <h1>My Homepage</h1>
         <ul>
            <li><a href="">로그인</a><li>
            <li><a href="">회원가입</a><li>
            <li><a href="">회원정보수정</a><li>
            <li><a href="">로그아웃</a><li>
            <li>님 안녕하세요 ^^;</li>
         </ul>
      </div>

      <div id="navigation">
         <ul>
            <li><a href="">My Home</a></li>
            <li><a href="">방명록</a></li>
            <li><a href="">게시판</a></li>
         </ul>
      </div>

      <div id="content">
         <div id="board">
            <!--form id="search_form" action="" method="post">
               <input type="text" id="kwd" name="kwd" value="">
               <input type="submit" value="찾기">
            </form -->
            <table class="tbl-ex">
               <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>글쓴이</th>
                  <th>조회수</th>
                  <th>작성일</th>
                  <th>&nbsp;</th>
               </tr>
               <c:forEach items="${list }" var="vo">
	               <tr>
	                  <td>${vo.no }</td>
	                  <td><a href="">${vo.title }</a></td>
	                  <td>${vo.userName }</td>
	                  <td>${vo.hit }</td>
	                  <td>${vo.regDate }</td>
                   	  <td><c:if test="${not empty authUser }">
                           <c:if test="${authUser.no == vo.userNo}">
                              <a href="">삭제</a>
                           </c:if>
                        </c:if>		
	               </tr>
               </c:forEach>
            </table>
            <!--div class="pager">
               <ul>
                  <li><a href="">◀</a></li>
                  <li><a href="">1</a></li>
                  <li><a href="">2</a></li>
                  <li class="selected">3</li>
                  <li><a href="">4</a></li>
                  <li>5</li>
                  <li><a href="">▶</a></li>
               </ul>
            </div -->
            <div class="bottom">
               <a href="${pageContext.servletContext.contextPath }/board/write" id="new-book">글쓰기</a>
               <%-- "${pageContext.servletContext.contextPath }/" 서버환경이 바뀌면 서버컨텍스트가 바뀔수도있어서 이렇게 잡는다 이것이 [기본화면설정임]--%>
            </div>
         </div>
      </div>

      <div id="footer">
         <p>(c)opyright 2015,2016,2017</p>
      </div> <!-- /footer -->

   </div>
</body>
</html>
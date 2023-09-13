<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 표현언어 taglib 외울것.. -->
    
<h1>list</h1>

<html>
<head>
<title>게시판</title>
</head>

<body >
<center> <b>글목록</b>
	<table width="700">
	<tr>
	    <td align="right" >
	    
	    <c:if test="${sessionScope.memId == null}">
	    <a href="/blog02/member/loginForm">로그인</a>
	    </c:if>
	    <c:if test="${sessionScope.memId != null}">
	    <a href="/blog02/picture/board">글쓰기</a>
	    <a href="/blog02/member/logout">로그아웃</a>
	    </c:if>
	    </td>
	</table>

		<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
			    <tr height="30"> 
			      <td align="center"  width="100" >글번호</td> 
			      <td align="center"  width="100" >작성자</td>
			      <td align="center"  width="100" >아이디</td> 
			      <td align="center"  width="150" >제  목</td> 
			      <td align="center"  width="200" >내용</td>  
			    </tr>
		    
		<c:forEach var="dto" items="${list}">	<!-- forEach는 향상된 for문과 같다~ -->
			<tr>
			    <td class="text_ct">${dto.num}</td> 
			    <td><a href="/blog02/picture/view?num=${dto.num}">${dto.title}</a>
			   	<td class="text_ct">${dto.id}</td> 
			  	<td class="text_ct">${dto.title} </td>
			  	<td class="text_ct">${dto.content} </td>
			</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>
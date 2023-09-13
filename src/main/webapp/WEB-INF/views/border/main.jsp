<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center><b>메인페이지</b></center>

<c:if test="${sessionScope.memId == null}">
	<a href="/blog02/member/loginForm">로그인</a>
</c:if>

<table align="center" width="500" height="60" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center" colspan="2">
			<a href="/blog02/border/bordermain">글게시판</a>
		</td>
		
		<td align="center" colspan="2">
			<a href="/blog02/guest/guestboard">방명록</a>
		</td>

		<td align="center" colspan="2">
			<a href="/blog02/roh/list">사진게시판</a>
		</td>
		
		<td align="center" colspan="2">
			<a href="/blog02/image/list">사진게시판1</a>
		</td>
		
		<td align="center" colspan="2">
			<a href="/blog02/picture/list">사진게시판2</a>
		</td>
</table>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.memId == null}">
	<script>
		alert('로그인을 해주세요');
	</script>
</c:if>

<c:if test="${list.size() == 0}">
	<table align="center" width="700" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center">작성된 게시글이 없습니다</td>
			<td align="right" colspan="4"><a href="borderWrite">글작성</a></td>
	</table>
</c:if>
	
	<c:if test="${list.size() != 0}">
		<table align="center" width="800" border="1" cellspacing="0" cellpadding="0">
			<tr height="30">
				<td align="center" width="50">글번호</td>
				<td align="center" width="500">글제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="100">작성일</td>
			<c:forEach var="dto" items="${list}">
			<tr height="20">
				<td align="center" width="50">${dto.num}</td>
				<td align="center" width="200"><a href="bordercon?num=${dto.num}&pageNum=${currentPage}">${dto.title}</a></td>
				<td align="center" width="100">${dto.id}</td>
				<td align="center" width="100">${dto.reg}</td>
			</tr>
			</c:forEach>
		<c:if test="${sessionScope.memId != null}">
				<td align="right" colspan="2"><a href="borderWrite">글작성</a></td>
				<td align="right"><a href="main">메인페이지</a></td>
				<td align="right"><a href="/blog02/member/logout">로그아웃</a></td>
		</c:if>
		</table>
	</c:if>
<form align="center">	
	<c:if test="${startPage > 10}">
		<a href="bordermain?pageNum=${startPage - 10}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="bordermain?pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage < pageCount}">
		<a href="bordermain?pageNum=${startPage + 10}">[다음]</a>
	</c:if>
</form>
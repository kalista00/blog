<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>리스트</h1>

<a href="/blog02/roh/main">메인</a>
<a href="/blog02/roh/write">글쓰기</a>

<hr />

<table align="center" border="1" cellspacing="0" cellpadding="0">
	<tr align="center" height="30">
		<td width="50">글번호</td>
		<td width="150">아이디</td>
		<td width="150">이름</td>
		<td width="200">제목</td>
		<td width="100">조회수</td>
		<td width="300">작성일자</td>
	</tr>
	<c:if test="${empty list}">
		<tr align="center" height="30">
			<td colspan="6">작성된 글이 없습니다</td>
		</tr>
	</c:if>
	<c:if test="${not empty list}">
		<c:forEach var="dto" items="${list}">
			<tr align="center" height="30">
				<td>${dto.num}</td>
				<td>${dto.id}</td>
				<td>${dto.name}</td>
				<td><a href="/blog02/roh/content?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.readCount}</td>
				<td><fmt:formatDate value="${dto.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<form align="center">
	<c:if test="${startPage > 10}">
		<a href="/blog02/roh/list?pageNum=${startPage - 10}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="/blog02/roh/list?pageNum=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${endPage > 10}">
		<a href="/blog02/roh/list?pageNum=${startPage + 10}">[다음]</a>
	</c:if>
</form>
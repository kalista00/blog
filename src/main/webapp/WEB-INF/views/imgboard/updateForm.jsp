<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>글쓰기</h1>

<a href="/blog02/roh/main">메인</a>

<hr />

<form action="/blog02/roh/updatePro" method="post" enctype="multipart/form-data">
	<table align="center" width="400" border="1" cellspacing="0" cellpadding="0">
		<tr align="center" height="30">
			<td>아이디</td>
			<td>
				<input type="hidden" name="id" value="${dto.id}" />
				<input type="hidden" name="num" value="${dto.num}" />
				${dto.id}</td>
		</tr>
		<tr align="center" height="30">
			<td>이름</td>
			<td>${dto.name}</td>
		</tr>
		<tr align="center" height="30">
			<td>비밀번호</td>
			<td><input type="text" name="pw" value="${dto.pw}" placeholder="글 비밀번호" /></td>
		</tr>
		<tr align="center" height="30">
			<td>제목</td>
			<td><input type="text" name="title" value="${dto.title}" placeholder="글 제목" /></td>
		</tr>
		<tr align="center" height="30">
			<td colspan="2">문의내용</td>
		</tr>
		<tr align="center">
			<td colspan="2"><textarea cols="50" rows="10" name="content" placeholder="문의내용">${dto.content}</textarea></td>
		</tr>
		<tr align="center" height="30">
			<td>이미지</td><td><input type="file" name="save"/></td>
		</tr>
		<tr align="center" height="30">
			<td colspan="2"><input type="submit" value="수정" /></td>
		</tr>
	</table>
</form>
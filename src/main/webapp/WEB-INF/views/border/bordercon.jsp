<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center><b>글내용</b></center>
<br>
<form>
	<table width="600" height="500" border="1" cellspacing="0" cellpadding="0" align="center">
		<tr width="8" height="8">
			<td align="center" width="10">글번호</td>
			<td align="center" width="10" colspan="3">${result.num}</td>
		</tr>
		<tr width="10" height="10">
			<td align="center" width="35">작성자</td>
			<td align="center" width="35" align="center">${result.id}</td>
			
			<td align="center" width="35">작성일</td>
			<td align="center" width="35" align="center">${result.reg}</td>
		</tr>
		<tr height="10">
			<td align="center" width="70">글제목</td>
			<td align="center" width="70" align="center" colspan="3">${result.title}</td>
		</tr>
		<tr height="30">
			<td align="center" width="125">글내용</td>
			<td align="center" width="400" height="300"colspan="3">${result.con}</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
			<c:if test="${result.id == id}">
				<input type="button" value="글수정" onclick="location.href='updateborder?num=${result.num}&pageNum=${pageNum}'">
				<input type="button" value="글삭제" onclick="location.href='deleteborder?num=${result.num}&pageNum=${pageNum}'">
			</c:if>
				<input type="button" value="글목록" onclick="location.href='bordermain'"></td>
		</tr>
	</table>
</form>


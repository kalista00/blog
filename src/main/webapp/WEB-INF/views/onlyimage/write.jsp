<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center>
<c:if test="${sessionScope.memId == null}">
로그인을 하시기 바랍니다.
<a href="/blog02/member/loginForm">로그인하기</a>
<a href="/blog02/image/list">글목록</a>

</c:if>
<c:if test="${sessionScope.memId != null}">
	<form action="/blog02/image/insertPro" method="post" enctype="multipart/form-data">
		<table>
			<tr><td colspan="2">갤러리 작성</td></tr>
			<tr><td>작성자 : </td>
				<td>
					
					
						${sessionScope.memId}
						<input type="hidden" name="writer" value="${sessionScope.memId}" />
					
				</td>
			</tr>
			<tr>
				<td>제목 : </td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>사진파일 : </td>
				<td><input type="file" name="save" /></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="password" name="pw" /></td>
			</tr>
			<tr> 
				<td colspan="2"><input type="submit" value="등록" /></td>
			</tr>
		</table> 
	</form>
	<a href="/blog02/image/list">글목록</a>
</c:if>
</center> 
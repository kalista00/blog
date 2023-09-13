<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="<%=request.getContextPath() %>"></c:set>
<title>제목을 입력해 주세요</title>
</head>
<body>
<form action="/blog02/guest/write" method="post" >
	<table class="table table-bordered" style="width: 500px;">
	<caption>방명록쓰기</caption>
		<tr>
			<th style="width: 100px;">작성자</th>
			<td>
			<input type="text" name="writer" style="width: 150px;"
			class="form-control" required="required" autofocus="autofocus">
			</td>
		</tr>
	<tr>
		<td colspan="2" align="center">
			<textarea style="width: 450px; height: 150px;" name="content"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<button type="submit" class="btn btn-success btn-sm">저장</button>
		<input type="reset" name="reset" value="취소">
	</tr>
	</table>
	</form>
	
	<br/>
	<table border ="1" width="700">
	<tr height="30" >
		<td align="center" width="50"	>번 호</td>
		<td align="center" width="100"	>작성자</td>
		<td align="center" width="250"	>내 용</td>
		<td align="center" width="150"	>작성일</td>
	</tr>
	
	<c:forEach var="dto" items="${list}"> 
		<form action="/blog02/guest/updateguest">
			<tr>		
				<td><c:out value="${dto.num}"/><input type="hidden" name="num" value="${dto.num}" /></td>
				<td><c:out value="${dto.writer}"/></td>
				<td><c:out value="${dto.content}"/></td>
				<td><c:out value="${dto.writeday}"/></td>
				<c:if test="${sessionScope.memId !=null }">
					<td><button type="submit" class="/blog02/guest/updateguest">수정</button>
					<textarea cols="40" rows="3" name="content"></textarea></td>
					<td><input type="button" value="삭제" onclick="location='/blog02/guest/deleteguest?num=${dto.num}'"></td>
				</c:if>
			</tr>
		</form>
		
	</c:forEach>
	</table>

</body>
</html>

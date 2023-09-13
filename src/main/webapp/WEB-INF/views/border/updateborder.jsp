<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>글수정</title>

<form name="updateborder" action="/blog02/border/updateborderPro?pageNum=${pageNum}" method="post">
	<table width="1000" heigth="800" border="1" cellspacing="0" cellpadding="3" align="center">
		<tr height="30">
			<td width="80" align="center">작성자</td>
			<td align="left" width="330">${result.id}
				<input type="hidden" name="num" value="${result.num}"></td>
		</tr>
		<tr height="30">
			<td width="80" align="center">글제목</td>
			<td align="left" width="330">
				<input type="text" size="100" maxlength="50" name="title" value="${result.title}"></td>
		</tr>
		<tr height="30">
			<td width="70" align="center">글내용</td>
			<td align="left" width="330">
				<textarea name="con" rows="44" cols="127">${result.con}</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글수정">
				<input type="reset" value="다시작성">
				<input type="button" value="글목록" onclick="location.href='bordermain'"></td>
		</tr>
	</table>
</form>
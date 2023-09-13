<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<center><b>글쓰기</b></center>
<br>
<form method = "post" name="borderWrite" action="/blog02/border/borderWritePro">
	<table width="1000" height="800" border="1" cellspacing="0" cellpadding="0" align="center">
		<tr height="30">
			<td width="80" align="center">글제목</td>
			<td width="330"><input type="text" size="100" maxlength="50" name="title"></td>
		</tr>
		<tr height="30">
			<td width="80" align="center">작성자</td>
			<td width="330">${sessionScope.memId}</td>
			
		</tr>
		<tr height="30">
			<td width="80" align="center">글내용</td>
			<td width="330"><textarea name="con" rows="44" cols="127"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="글작성">
				<input type="reset" value="다시작성">
				<input type="button" value="작성취소" onclick="location='bordermain'">
			</td>
		</tr>
	</table>
</form>
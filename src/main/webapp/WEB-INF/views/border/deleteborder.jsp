<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>글삭제</title>

<center><b>글삭제</b></center>
<br>
	<form method="post" name="deleteborder" action="deleteborderPro?num=${num}">
		<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
			<tr height="30">
				<td align="center">
					<input type="submit" value="글삭제">
					<input type="button" value="글목록" onclick="location.href='bordermain'">
				</td>
			</tr>
		</table>
	</form>
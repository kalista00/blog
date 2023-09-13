<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body bgcolor="#FFFFFF">
  <p>게시판 글쓰기</p>
	  <form name="form" method="post" action="/blog02/picture/insert" enctype="multipart/form-data">
	 	 <table width="530" border="0" cellspacing="1" cellpadding="5">
			 <tr>
	      		<td width="20%" height="25">작성자</td>
	   			<td width="70%" height="25">
	   			${sessionScope.memId }
	   			<input type="hidden" name="writer"  value="${sessionScope.memId }" size="15" maxlength="10"></td>
	 		 </tr>
	 		 <tr>
	  		    <td width="20%" height="25">아이디</td>
	  			<td width="70%" height="25">
	  			<input type="text" name=id size="15" maxlength="10"></td>
	  		</tr>
	  		<tr>
	     		<td width="20%" height="25">제목</td>
	 		 	<td width="70%" height="25">
	   			<input type="text" name="title" size="50" maxlength="50"></td>
	  		</tr>
	  		<tr>
	      		<td width="20%" height="25">내용</td>
	   			<td width="70%"  height="100">
	   			<textarea name="content" ></textarea></td>
	  			</tr>
	  			<tr>
	      		<td width="20%" height="25">사진파일</td>
	   			<td width="70%"  height="100">
	   			<input type="file" name="save" /></td>
	  			</tr>
	  			<tr>
	      		<td width="20%" height="25">비밀번호</td>
	   			<td width="70%" height="25">
	   			<input type="text" name="pw" size="10" maxlength="5"></td>
	  		</tr>
 		 </table>
  	<input type="submit" value="등 록">
	</form>
</body>
</html>
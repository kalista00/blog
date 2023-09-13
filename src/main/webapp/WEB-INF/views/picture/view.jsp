<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<center><b>글내용 보기</b>
<br>
	
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">  
  <tr height="30">
	    <td align="center" width="125" >글번호</td>
	    <td align="center" width="125" align="center">
	    <div class="num">${dto.num }</div>
</td>
  </tr>
  <tr height="30">
	    <td align="center" width="125" >작성자</td>
	    <td align="center" width="125" >
	    <div class="writer">${dto.writer}</div>	
  </td>
  </tr>
  <tr height="30">
	    <td align="center" width="125" >글제목</td>
	    <td align="center" width="375"  colspan="3" />
	    <div class="title">${dto.title}</div>
  </tr>
    <tr height="30">
	    <td align="center" width="125" >아이디</td>
	    <td align="center" width="375"  colspan="3" />
	    <div class="id">${dto.id}</div>
  </tr>
  <tr height="30">
	    <td align="center" width="125">글내용</td>
	    <td align="center" width="375" colspan="3" />
	    <div class="content">${dto.content}</div>
  </tr>
  <tr height="30">
	    <td align="center" width="125">사진</td>
	    <td align="center" width="375" colspan="3" />
	    <div class="content">
	    <img src="/blog02/resources/img/${dto.pic}" height="100" width="300"/>
	    </div>
  </tr>
</table>    
</form>  
  <tr height="30" align="right">
  	<td>
		<input type="button" value="글목록" onclick="location.href='./list'">
		<c:if test="${sessionScope.memId == dto.writer}">
		<input type="button" value="수 정" onclick="location.href='./modify?num=${dto.num}'">
		<input type="button" value="삭 제" onclick="location.href='./delete?num=${dto.num}'">
		</c:if>
	</td>
  </tr>
   
</body>
</html>     
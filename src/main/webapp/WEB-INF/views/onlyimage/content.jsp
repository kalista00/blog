<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<center><b>글내용 보기</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">  
  <tr height="30">
    <td align="center" width="125" >글번호</td>
    <td align="center" width="125" colspan="3">
	     ${condata.num}</td>
    
  </tr>
  <tr height="30">
    <td align="center" width="125" >작성자</td>
    <td align="center" width="125" align="center" colspan="3">
	     ${condata.writer}</td>
  </tr>
  <tr height="30">
    <td align="center" width="125" >글제목</td>
    <td align="center" width="375" align="center" colspan="3">
	     ${condata.title}</td>
  </tr>
  <tr>
    <td align="center" width="125">글내용</td>
    <td align="left" width="375" colspan="3">
    <img src="/blog02/resources/img/${condata.picture}" height="400" width="800"/></td>
  </tr>
  
  <tr height="30">      
    <td colspan="4" align="right" >
    <c:if test="${writer.equals(sessionScope.memId)}"> 
	  <input type="button" value="글수정" 
       onclick="document.location.href='/blog02/image/updateForm?num=${condata.num}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
	  <input type="button" value="글삭제" 
       onclick="document.location.href='/blog02/image/delete?num=${condata.num}'">
	   &nbsp;&nbsp;&nbsp;&nbsp;
	</c:if>   
       <input type="button" value="글목록" 
       onclick="document.location.href='/blog02/image/list'">
    </td>
  </tr>

</table>    

</form>     
      
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="updatePro" method="post" enctype="multipart/form-data">
<input type="hidden" name="writer" value="${condata.writer}"/>
<input type="hidden" name="num" value="${condata.num}"/>

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
	     <input type="text" name="title" value="${condata.title}" />
	</td>
  </tr>
  <tr>
    <td align="center" width="125">글내용</td>
    <td align="left" width="375" colspan="3">
    	<input type="file" name="save" />
    </td>
  </tr>
  
  <tr height="30">      
    <td colspan="4" align="right" > 
	  <input type="submit" value="수정완료" />&nbsp;&nbsp;
	  <input type="reset" value="리셋" />&nbsp;&nbsp;
	  <input type="button" value="글목록" 
       onclick="document.location.href='/blog02/image/list'">
    </td>
  </tr>

</table>    

</form> 
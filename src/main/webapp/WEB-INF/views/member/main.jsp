<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/color.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.Cookie" %>
<html>
<head><title>메인입니다..</title>
<link href="/WEB-INF/views/member/style.css" rel="stylesheet" type="text/css">

</head>
	<c:if test="${memId == null && cookie.memId.value == null}">

<script language="javascript">
<!--
function focusIt()
{      
   document.inform.id.focus();
}
 
 function checkIt()
 {
   inputForm=eval("document.inform");
   if(!inputForm.id.value){
     alert("아이디를 입력하세요..");
	 inputForm.id.focus();
	 return false;
   }
   if(!inputForm.passwd.value){
     alert("아이디를 입력하세요..");
	 inputForm.passwd.focus();
	 return false;
   }
 }
//-->
</script>
</head>

<body onLoad="focusIt();" bgcolor="${bodyback_c}">
  <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
  	<form name="inform" method="post" action="/blog02/member/loginCheck"  onSubmit="return checkIt();" >
      <tr>
       <td width="300" bgcolor="${bodyback_c}" height="20">
       &nbsp;
       </td>
       
        <td bgcolor="${title_c}"  width="100" align="right">아이디</td>
        <td width="100" bgcolor="${value_c}">
            <input type="text" name="id" size="15" maxlength="10"></td>
      </tr>
      <tr > 
         <td rowspan="2" bgcolor="${bodyback_c}" width="300" >메인입니다.</td>
         
         <td bgcolor="${title_c}"  width="100" align="right">패스워드</td>
         <td width="100" bgcolor="${value_c}">
            <input type="password" name="passwd" size="15" maxlength="10"></td>
       </tr>
       <tr>
          <td colspan="3" bgcolor="${title_c}"   align="center">
            <input type="submit" name="Submit" value="로그인">
        
            <input type="button"  value="회원가입" onclick="javascript:window.location='/blog02/member/inputForm'" />
            <button type="button" class="btn btn-primary" value="블로그" onclick="javascript:window.location='/blog02/border/main'">
          </td>
        </tr>
        </form>
   </table>
          
	</c:if> 
	<c:if test="${memId != null || cookie.memId.value != null}">
       <table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
         <tr>
           <td width="300" bgcolor="${bodyback_c}" height="20">하하하</td>

           <td rowspan="3" bgcolor="${value_c}" align="center">
             ${memId}님이 <br>
             방문하셨습니다
			<form action="logout" method="post" >
			<input type="submit" value="로그아웃" />
			</form>
             <input type="button" value="회원정보변경" onclick="javascript:window.location='/blog02/member/modify'">
             <input type="button" value="블로그" onclick="javascript:window.location='/blog02/border/main'">
         </td>
        </tr>
       <tr > 
         <td rowspan="2" bgcolor="${bodyback_c}" width="300" >메인입니다.</td>
      </tr>
     </table>
     <br>
	</c:if>

<h1>${cookie.memId.value }</h1>
 </body>
</html>

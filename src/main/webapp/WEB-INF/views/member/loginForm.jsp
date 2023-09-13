<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/member/color.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>로그인</title>
<link href="/WEB-INF/views/member/style.css" rel="stylesheet" type="text/css">

   <script language="javascript">
     <!--
       function begin(){
         document.myform.username.focus();
       }
       function checkIt(){
         if(!document.myform.username.value){
           alert("아이디를 입력하지 않으셨습니다.");
           document.myform.username.focus();
           return false;
         }
         if(!document.myform.password.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.myform.password.focus();
           return false;
         }
         
       }
     -->
   </script>
</head>
<BODY onload="begin()" bgcolor="${bodyback_c}">
<form name="myform" action="/blog02/member/loginCheck" method="post" onSubmit="return checkIt()">
<TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
  
  <TR height="30">
    <TD colspan="2" align="middle" bgcolor="${title_c}"><STRONG>회원로그인</STRONG></TD></TR>
  
  <TR height="30">
    <TD width="110" bgcolor="${title_c}" align=center>아이디</TD>
    <TD width="150" bgcolor="${value_c}" align=center>
       <INPUT type="text" name="id" size="15" maxlength="12"></TD></TR>
  <TR height="30">
    <TD width="110" bgcolor="${title_c}" align=center>비밀번호</TD>
    <TD width="150" bgcolor="${value_c}" align=center>
      <INPUT type=password name="passwd"  size="15" maxlength="12"></TD></TR>
  <TR height="30">
    <TD colspan="2" align="middle" bgcolor="${title_c}" >
      <INPUT type=submit value="로그인"> 
      <INPUT type=reset value="다시입력">
</form>
      <input type="button" value="회원가입" onclick="javascript:window.location='/blog02/member/inputForm'"></TD></TR>

</TABLE>
<c:forEach var="i" begin="1" end="3" >
${i}
</c:forEach>

</BODY>
</HTML>
<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<title>게시판</title>



<center>



<b>글목록</b>

<table width="700">
<tr>
    <td align="right">
    <c:if test="${sessionScope.memId == null}">
    로그인을 하지 않을 시 글을 작성할 수 없습니다.
    <a href="/blog02/member/loginForm">로그인하기</a>
    </c:if>
    <c:if test="${sessionScope.memId != null}">
    <a href="/blog02/image/insertForm">글쓰기</a>
    
    <a href="/blog02/member/logout">로그아웃</a>
    </c:if>
    </td>
</tr>
</table>



<table width="700" border="1" cellpadding="0" cellspacing="0">

</table>



<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30"> 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="300" >그림</td>    
    </tr>


<c:if test="${list == null}">	
<tr>
    <td align="center" colspan="4">
    게시판에 저장된 글이 없습니다.
    </td>
</tr>
</c:if>



<c:if test="${list != null}">
<c:forEach var="info" items="${list}">
   
   <tr height="100">
    <td align="center" width="50">${info.num}</td>
    <td align="center" width="250"><a href="/blog02/image/content?num=${info.num}">${info.title}</a></td>
    <td align="center" width="100">${info.writer}</td>
    <td align="center" width="300" ><img src="/blog02/resources/img/${info.picture}" height="100" width="300"/></td>
  </tr>
  
</c:forEach>

<c:if test="${startPage > 10}">
<a href="/blog02/image/list?pageNum=${startPage - 10}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage}" >
<a href="/blog02/image/list?pageNum=${i}">[${i}]</a>
</c:forEach>
<c:if test="${endPage < pageCount}">
<a href="/blog02/image/list?pageNum=${startPage + 10}">[이전]</a>
</c:if>

</c:if>     
</table>



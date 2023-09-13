<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>리스트</h1>

<a href="/blog02/roh/main">메인</a>

<hr />

<table align="center" width="900" border="1" cellspacing="0">
	<tr height="30">
		<td align="center" colspan="3">${dto.title}</td>
	</tr>
	<tr height="20">
		<td align="center" width="300">작성자 : ${dto.id}(${dto.name})</td>
		<td align="center" width="300">조회수 : ${dto.readCount}</td>
		<td align="center" width="300">작성일자 : <fmt:formatDate value="${dto.reg_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	<tr>
		<td align="center" colspan="3" height="200">
			${dto.content}<br />
			<img src="/blog02/resources/img/${dto.img}" width="600" />
		</td>
	</tr>
	<tr>
		<td align="center"><input type="button" value="목록" onclick="location='/blog02/roh/list'" /></td>
		<td align="center"><input type="button" value="수정" onclick="location='/blog02/roh/update?num=${dto.num}&id=${dto.id}'" /></td>
		<td align="center"><input type="button" value="삭제" onclick="location='/blog02/roh/delete?num=${dto.num}&id=${dto.id}'" /></td>
	</tr>
</table>
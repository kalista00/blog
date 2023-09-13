<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br>	
<body>
	<h2>update</h2>
	<form name="modify" method="post" action="/blog02/picture/modifyPro" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${dto.num}"/>
		<div>글번호 : ${dto.num}</div>
		<div>작성자 : </div>
		<div><input type="text" name="writer" value="${dto.writer}"/></div>
		<div>글제목 : </div>
		<div><input type="text" name="title" value="${dto.title}"></div>
		<div>아이디 : </div>
		<div><input type="text" name="id" value="${dto.id }"/></div>
		<div>글내용 : </div>
		<div><input type="text" name="content" value="${dto.content }"></div>
		<div>사진 : </div>
		<div><input type="file" name="save" value="${dto.pic }"/></div>
		
		
		<div>
			<input type="submit" class="btn btn-outline-info" value="완료" />
			<input type="reset" class="btn btn-outline-info" value="리셋" />
		</div>
	</form>
</body> 
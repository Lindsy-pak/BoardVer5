<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<script defer src="/res/js/boardList.js"></script><!-- defer는 먼저 읽었지만 모든 일이 끝난뒤에 실행 -->
<!-- 스크립트는 ../로 상대경로 x 무조건 절대경로로 해야한다. -->
<link rel="stylesheet" type="text/css" href="/res/css/boardList.css">
</head>
<body>
	<h1>리스트</h1>
	<h1>${loginUser.unm}님 환영합니다.</h1><!-- session에 unm을 담았기 때문에 -->
	<!-- ${sessionScope.loginUser.unm} : 성능향상 (pageContext,request에서 안찾아도 되기 때문에)   -->
	<div><a href="/user/logout"></a></div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일시</th>
			</tr>
			
			<c:forEach items="${list}" var="item"><!--${requestScope.list} -->
				<tr class="record" onclick="moveToDetail(${item.iboard})">
					<td>${item.iboard}</td> 
					<td>${item.title}</td>
					<td>${item.unm}</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
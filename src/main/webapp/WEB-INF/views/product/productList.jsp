<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<table border="1">
			<thead>
				<tr>
					<th width="400">제품이미지</th>
					<th width="200">제품명</th>
					<th width="200">제품가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="p" >
					<tr>
						<td>${p.productImg}</td>
						<td align="center">${p.productName }</td>
						<td>${p.productPrice }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div><br>
</body>
</html>
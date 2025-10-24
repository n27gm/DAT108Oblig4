<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/simple.css">
	<title>Deltagerliste</title>
</head>

<body>
	<h2>Deltagerliste</h2>
	<table>
		<tr>
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach var="deltager" items="${deltagerliste}">
			<tr>
				<td align="center">
					<c:choose>
						<c:when test="${deltager.kjonn == 'mann'}">♂</c:when>
						<c:otherwise>♀</c:otherwise>
					</c:choose>
				</td>
				<td>${deltager.fulltNavn}</td>
				<td>${deltager.mobil}</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>
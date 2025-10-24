<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="no">

<head>
	<link href="${pageContext.request.contextPath}/css/simple.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/myscript.js" defer></script>  
	<title>Påmelding</title>
</head>

<body id="root">
	<h2>Påmelding</h2>
	
	<c:if test="${not empty param.feilmelding}">
		<p style="color:red;">${param.feilmelding}</p>
	</c:if>
	
	<c:if test="${empty param.feilmelding}">
		<p class="hidden" style="color:red;">Påmeldingsdetaljer er ugyldige</p>
	</c:if>

	<form name="paamelding" action="${pageContext.request.contextPath}/paamelding" method="post">
		<label for="fornavn">Fornavn</label>
		<input type="text" id="fornavn" name="fornavn" maxlength="20"
			pattern="\s*\p{Lu}{1}\p{Ll}+((\s+|-)\p{Lu}{1}\p{Ll}+)*\s*" 
			value="${param.fornavn}" required>
			
		<label for="etternavn">Etternavn</label>
		<input type="text" id="etternavn" name="etternavn" maxlength="20"
			pattern="\p{Lu}{1}\p{Ll}+(\p{Pd}\p{Lu}{1}\p{Ll}+)*" 
			value="${param.etternavn}" required>
			
		<label for="mobil">Mobil (8 siffer)</label>
		<input type="text" id="mobil" name="mobil" pattern="\d{8}" 
			value="${param.mobil}" required>
			
		<label for="passord">Passord</label>
		<input type="password" id="passord" name="passord" minlength="8" required>
		
		<label for="rpassord">Passord repetert</label>
		<input type="password" id="rpassord" name="rpassord" minlength="8" required>
		
		<p>Kjønn</p>
		<div id="radio-kjonn" class="kjonn">
			<input type="radio" id="mann" name="kjonn" value="mann" 
				<c:if test="${param.kjonn == 'mann'}">checked</c:if>>
			<label for="mann">mann</label>
			
			<input type="radio" id="kvinne" name="kjonn" value="kvinne"
				<c:if test="${param.kjonn == 'kvinne'}">checked</c:if>>
			<label for="kvinne">kvinne</label>
		</div>
		
		<input id="submit" type="submit" value="Meld meg på">
	</form>

</body>

</html>
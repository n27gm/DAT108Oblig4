<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="no">

<head>
	<meta charset="UTF-8">
	<link href="${pageContext.request.contextPath}/css/simple.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/js/myscript.js" defer></script>  
	<title>Påmelding</title>
	<style>
		.feilmelding {
			color: red;
			font-size: 0.9rem;
			margin-top: 0.2rem;
			margin-bottom: 0.5rem;
		}
		.feil-input {
			border: 2px solid red !important;
		}
	</style>
</head>

<body id="root">
	<h2>Påmelding</h2>

	<form name="paamelding" action="${pageContext.request.contextPath}/paamelding" method="post">
		
		<!-- Fornavn -->
		<label for="fornavn">Fornavn</label>
		<input type="text" id="fornavn" name="fornavn" maxlength="20"
			pattern="[A-ZÆØÅ][a-zæøå]+([\s\-][A-ZÆØÅ][a-zæøå]+)*" 
			value="${fornavn}" 
			class="${not empty fornavnFeil ? 'feil-input' : ''}"
			required>
		<c:if test="${not empty fornavnFeil}">
			<div class="feilmelding">${fornavnFeil}</div>
		</c:if>
			
		<!-- Etternavn -->
		<label for="etternavn">Etternavn</label>
		<input type="text" id="etternavn" name="etternavn" maxlength="20"
			pattern="[A-ZÆØÅ][a-zæøå]+(\-[A-ZÆØÅ][a-zæøå]+)*" 
			value="${etternavn}"
			class="${not empty etternavnFeil ? 'feil-input' : ''}"
			required>
		<c:if test="${not empty etternavnFeil}">
			<div class="feilmelding">${etternavnFeil}</div>
		</c:if>
			
		<!-- Mobil -->
		<label for="mobil">Mobil (8 siffer)</label>
		<input type="text" id="mobil" name="mobil" pattern="\d{8}" 
			value="${mobil}"
			class="${not empty mobilFeil ? 'feil-input' : ''}"
			required>
		<c:if test="${not empty mobilFeil}">
			<div class="feilmelding">${mobilFeil}</div>
		</c:if>
			
		<!-- Passord -->
		<label for="passord">Passord</label>
		<input type="password" id="passord" name="passord" minlength="8"
			class="${not empty passordFeil ? 'feil-input' : ''}"
			required>
		<c:if test="${not empty passordFeil}">
			<div class="feilmelding">${passordFeil}</div>
		</c:if>
		
		<!-- Passord repetert -->
		<label for="rpassord">Passord repetert</label>
		<input type="password" id="rpassord" name="rpassord" minlength="8"
			class="${not empty rpassordFeil ? 'feil-input' : ''}"
			required>
		<c:if test="${not empty rpassordFeil}">
			<div class="feilmelding">${rpassordFeil}</div>
		</c:if>
		
		<!-- Kjønn -->
		<p>Kjønn</p>
		<div id="radio-kjonn" class="kjonn">
			<input type="radio" id="mann" name="kjonn" value="mann" 
				${kjonn == 'mann' ? 'checked' : ''}>
			<label for="mann">mann</label>
			
			<input type="radio" id="kvinne" name="kjonn" value="kvinne"
				${kjonn == 'kvinne' ? 'checked' : ''}>
			<label for="kvinne">kvinne</label>
		</div>
		<c:if test="${not empty kjonnFeil}">
			<div class="feilmelding">${kjonnFeil}</div>
		</c:if>
		
		<input id="submit" type="submit" value="Meld meg på">
	</form>

</body>

</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<html>
<head>
<title>Piece Details</title>
</head>
<section id="pieceDetail">
	<div id="wrapper">
		<h2><c:out value="Call Number: ${catalogueId.catalogueId}" /></h2>
		<c:out value=" Composer: ${catalogueId.composerFirstName} ${catalogueId.composerLastName}"  /><br>
		<c:out value="Title: ${catalogueId.title}" /><br>
		<c:out value="Genre: ${catalogueId.genre}" /><br>
		<c:out value="Publisher: ${catalogueId.publisher}" /><br>
		<c:if test = "${catalogueId.soloInstrument != NULL}">
			<c:out value="Solo Instrument: ${catalogueId.soloInstrument}" />
		</c:if>
	</div>
</section>
</html>
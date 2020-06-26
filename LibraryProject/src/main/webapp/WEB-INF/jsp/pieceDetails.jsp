<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<html>
<head>
<title>Piece Details</title>
</head>
<section id="pieceDetail">
	<h2><c:out value='Call Number: ${catalogueId.catalogueId}' /></h2>
	<c:out value=" Composer: ${catalogueId.composer}" /><br>
	<c:out value="Title: ${catalogueId.title}" /><br>
	<c:out value="Ensemble: ${catalogueId.ensembleType}" /><br>
	<c:out value="Publisher: ${catalogueId.publisher}" /><br>
</section>
</html>
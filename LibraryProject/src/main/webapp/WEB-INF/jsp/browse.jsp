<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<html>
<head>
<meta charset="ISO-8859-1">
<title>Browse Ensembles</title>
</head>
<body>
	<div id="wrapper">
		<h1>Browse by Genre and Ensemble Type:</h1>

		<div>
			<label for="ensembleType">Ensemble Type:</label> 

			<c:url value='/browseSelection' var='browseSelectionVar'>
				<c:param name='request' value="${request}"/>
			</c:url>
			<form action="${browseSelectionVar}" method="GET">			
				<select name="genre" id="genre" onchange="this.form.submit();">
					<option value="Select...">Select...</option>
					<option value="Chamber Symphony">Chamber Symphony</option>
					<option value="Concerto">Concerto</option>
					<option value="Holiday">Holiday</option>
					<option value="Concerto">Concerto</option>
					<option value="Opera">Opera</option>
					<option value="Orchestra and choir">Orchestra and Choir</option>
					<option value="Patriotic">Patriotic</option>
					<option value="Pops">Pops</option>
					<option value="Small Ensemble">Small Ensemble</option>
					<option value="String Orchestra">String Orchestra</option>
					<option value="String Quartet">String Quartet</option>
					<option value="Symphony Orchestra">Symphony Orchestra</option>
					<option value="Wind Ensemble">Wind Ensemble</option>
				</select>
			</form>
		</div>
	
			<br><hr><br>

		<table class="catalogue">
			<tr>
				<th align="left">Call No.</th>
				<th align="left">Composer</th>
				<th align="left">Title</th>
				<th align="left">Publisher</th>
				<th align="left">Genre</th>
				<th align="left">Solo Instrument</th>
			</tr>
		
	<c:forEach items="${allPieces}" var="piece">
		<c:url value='/pieceDetails' var='detailsUrl'>
			<c:param name='catalogueId' value='${piece.catalogueId}' />
		</c:url>
		<tr>
			<td><c:out value="${piece.catalogueId}" /></td>
			<td><c:out value="${piece.composerLastName}" /></td>
			<c:url value='/add' var='addUrl'/>
			<td><a href='${detailsUrl}'>${piece.title}</a></td>
			<td><c:out value="${piece.publisher}" /></td>
			<td><c:out value="${piece.genre}" /></td>
			<c:if test="${piece.genre == 'Concerto'}">
				<td><c:out value="${piece.soloInstrument}" /></td>
			</c:if>
			<tr>
		</c:forEach>
	</table>
	<br>
</div>

</body>
</html>
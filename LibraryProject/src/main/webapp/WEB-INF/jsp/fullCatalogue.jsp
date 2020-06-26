<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<input type="hidden" name="request" value="${request}"/>
<html>
<head>
<title>Library Catalogue Home</title>
</head>
<body>
<div>
	<h1>Search</h1>
		<p><em>Below you can scroll through the entire library catalogue, shown alphabetically by composer last name, or search the collection. 
		Click on the title for details about the piece.</em></p>
		<br><br>

		<div id="catSearchForm">	
			<c:url value='/catalogueSearchResults' var='catSearchVar'>
				<c:param name='request' value="${request}"/>
			</c:url>
			
				<form method="GET" action="${catSearchVar}">
					<div>
						<label for="title">Title:</label> 
						<input type="text" name="searchTitle" placeHolder="Title" id="searchTitle" />
					</div>

					<div class="form-group pull-right">
						<label for="composer">Composer:</label> 
						<input type="text" name="searchComposer" placeholder="Composer" id="searchComposer" />
					</div>

			<button type="submit">Search</button>	
		</form>
	</div>
		<br><br>

		<table class="catalogue">
			<tr>
				<th align="left">Call No.</th>
				<th align="left">Composer</th>
				<th align="left">Title</th>
				<th align="left">Ensemble</th>
				<th align="left">Publisher</th>
			</tr>
		
	<c:forEach items="${allPieces}" var="piece">
		<c:url value='/pieceDetails' var='detailsUrl'>
			<c:param name='catalogueId' value='${piece.catalogueId}' />
		</c:url>
		<tr>
			<td><c:out value="${piece.catalogueId}" /></td>
			<td><c:out value="${piece.composer}" /></td>
			<c:url value='/add' var='addUrl'/>
			<td><a href='${detailsUrl}'>${piece.title}</a></td>
			<td><c:out value="${piece.ensembleType}" /></td>
			<td><c:out value="${piece.publisher}" /></td>
			<tr>
		</c:forEach>
	</table>
	
</div>	
</body>
</html>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
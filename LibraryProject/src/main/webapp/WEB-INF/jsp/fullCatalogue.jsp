<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<input type="hidden" name="request" value="${request}"/>
<html>
<head>
<title>Library Catalogue Home</title>
</head>
<body>
	<div id="wrapper">
		<h1>Search</h1>
			<p>Below you can scroll through the entire library catalogue, shown alphabetically by composer last name. You can go directly to a piece's 
				details if you search its call number, or you can search by composer or title. Click on the title for details about the piece.</p> 
			<p>Search Tips:</p>
				<li> All searches will work with partial words; for example, "Tchaikovsky", "T", and "sky" will all bring up works by Tchaikovsky. </li>
				<li> Words in the catalogue do not contain accents or other non-English characters; for example, "Faure", "Bartok", and "Dvorak".</li>
		 	<p>If you would like to browse by genre, click <c:url var="browseHref" value="/browse"/><a href="${browseHref}">here</a>.</p>
		<br>
			
		<c:url value='/searchByIdResults' var='idSearchVar'>
			<c:param name='request' value="${request}"/>
		</c:url>			
			<form method="GET" action="${idSearchVar}">
				<div>
					<label for="catalogueId">Call Number:</label> 
					<input type="number" name="catalogueId" placeHolder="Number" id="catalogueId" min="0"/>
				</div>
				<button type="submit">Search</button>	
			</form>

		<br>
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
						<label for="composer">Composer (Last Name):</label> 
						<input type="text" name="searchComposer" placeholder="Composer" id="searchComposer" />
					</div>
				<button type="submit">Search</button>	
			</form>		

	</div>
		<br><hr><br>

		<table class="catalogue">
			<tr>
				<th align="left">Call No.</th>
				<th align="left">Composer</th>
				<th align="left">Title</th>
				<th align="left">Genre</th>
				<th align="left">Publisher</th>
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
			<td><c:out value="${piece.genre}" /></td>
			<td><c:out value="${piece.publisher}" /></td>
			<tr>
		</c:forEach>
	</table>
	
</div>	
</body>
</html>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
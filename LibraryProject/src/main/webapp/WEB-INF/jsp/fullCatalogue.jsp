<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<html>
<head>
<title>Library Catalogue Home</title>
</head>
<body>
	<p><em>Below you can scroll through the entire library catalogue, shown alphabetically by composer last name. Click on the title for details about the piece.</em></p>
		<table>
			<tr>
				<th align="left">Call No.</th>
				<th align="left">Composer</th>
				<th align="left">Title</th>
				<th align="left">Ensemble</th>
				<th align="left">Publisher</th>
			</tr>
		
	<c:forEach items="${allPieces}" var="piece">
		<c:url value='/details' var='detailsUrl'>
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
		
</body>
</html>
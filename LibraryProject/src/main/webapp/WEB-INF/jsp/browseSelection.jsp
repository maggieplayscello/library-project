<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Pieces for '${param}'</title>
</head>
<body>
		<table>
			<tr>
				<th>Call Number</th>
				<th>Composer</th>
				<th>Title</th>
				<th>Publisher</th>
			</tr>
		
	<c:forEach items="${allPieces}" var="piece">
		<c:url value='/details' var='detailsUrl'>
			<c:param name='catalogueId' value='${piece.catalogueId}' />
		</c:url>
		<tr>
			<c:url value='/add' var='addUrl'/>
			<td><a href='${detailsUrl}'>Details</a></td>
			<td><c:out value="${piece.catalogueId}" /></td>
			<td><c:out value="${piece.composer}" /></td>
			<td><c:out value="${piece.title}" /></td>
			<td><c:out value="${piece.publisher}" /></td>
			<tr>
		</c:forEach>
	</table>
</body>
</html>